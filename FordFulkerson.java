import java.util.*;
public class FordFulkerson{
    static int v=6;
    public static boolean dfs(int[][] graph, boolean[] vis,int s, int t,List<Integer> parent ){
        if(s==t){
            parent.add(s);
            return true;
        }
        vis[s]=true;
        for(int i=0;i<v;i++){
            if(!vis[i] && graph[s][i]!=0 && dfs(graph,vis,i,t,parent)){
                parent.add(s);
                vis[s]=false;
             return true;    
            }
        }
        vis[s]=false;
        return false;
    }
    public static void main(String[] argv){
        int[][] graph = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };
        int max_flow=0;
        boolean[] vis= new boolean[v];
        while(true){
            List<Integer> parent= new ArrayList<>();
            // System.out.println("hello");
            if(!dfs(graph,vis,0,5,parent)) break;
            int miny=Integer.MAX_VALUE;
            Collections.reverse(parent);
            for(int i=0;i<parent.size()-1;i++){
                int u=parent.get(i);
                int v=parent.get(i+1);
                miny=Math.min(miny,graph[u][v]);
            }
            for(int i=0;i<parent.size()-1;i++){
                int u=parent.get(i);
                int v=parent.get(i+1);
                graph[u][v]-=miny;
                graph[v][u]+=miny;
            }
            max_flow+=miny;
        }
        System.out.println(max_flow);
    }
}