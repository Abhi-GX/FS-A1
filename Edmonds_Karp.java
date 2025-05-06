import java.util.*;
public class Edmonds_Karp{
    static int v=6;
    public static boolean bfs(int[][] graph, int s, int t, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];
        
        q.offer(s);
        vis[s] = true;  
        parent[s] = -1;
    
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i = 0; i < v; i++) {
                if (!vis[i] && graph[c][i] > 0) {
                    parent[i] = c;
                    vis[i] = true;
                    q.offer(i);
    
                    if (i == t) {
                        return true; 
                    }
                }
            }
        }
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
        int s=0;
        int t=5;
        while(true){
            int[] parent=new int[v];
            if(!bfs(graph,s,t,parent)) break;
            int miny=Integer.MAX_VALUE;
            int idx=t;
            while(idx!=0){
                int u=parent[idx];
                int v=idx;
                miny=Math.min(miny,graph[u][v]);
                idx=parent[idx];
            }
            idx=t;
            while(idx!=0){
                int u=parent[idx];
                int v=idx;
                graph[u][v]-=miny;
                graph[v][u]+=miny;
                idx=parent[idx];
            }
            max_flow+=miny;
        }
        System.out.println(max_flow);
    }
}
