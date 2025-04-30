import java.util.*;
public class Dijastras {
    public static void helper(int[][] graph , int src){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] e=pq.poll();
            int u=e[0];
            int w=e[1];
            if(w>graph[src][u]) continue;
            for(int i=1;i<graph.length;i++){
                if(u!=i && graph[u][i]!=Integer.MAX_VALUE){
                    if(graph[src][i]>=graph[u][i]+w){
                        graph[src][i]=graph[u][i]+w;
                        System.out.println(src+" "+graph[src][i]);
                        pq.offer(new int[]{i,graph[src][i]});
                    }
                }
            }
        }
        
    }
    public static void main(String[] args) {
        int[] nodeFrom = {1, 1, 2};
        int[] nodeTo = {2, 3, 4};
        int[] weights = {3, 4, 5};
        int n=4;
        int signal=2;
        int[][] graph= new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
          Arrays.fill(graph[i],Integer.MAX_VALUE);  
          graph[i][i]=0;
        }
        for(int i=0;i<nodeTo.length;i++){
            graph[nodeTo[i]][nodeFrom[i]]=weights[i];
            graph[nodeFrom[i]][nodeTo[i]]=weights[i];
        }
        for(int i=1;i<graph.length;i++){
            helper(graph,i);
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=1;i<n+1;i++){
            int count=-1;
            for(int j=1;j<n+1;j++){
                if(graph[i][j]%2==0){
                    count++;
                }
            }
            System.out.print(count+" ");
        }
        // System.out.println("Try programiz.pro");
    }
}
