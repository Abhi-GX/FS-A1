// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class BridgesGraph {
    public static int[] insert;
    public static int[] lsi;
    public static boolean[] vis;
    static int row;
    public static void dfs(int[][] grid, int node,List<String> res,int inc,int parent){
        insert[node]=inc;
        lsi[node]=inc;
        vis[node]=true;
        for(int i=0;i<row;i++){
            if(grid[node][i]==1 && i!=node && i!=parent){
                if(!vis[i]){
                    dfs(grid,i,res,++inc,node);
                }
                lsi[node]=Math.min(lsi[i],lsi[node]);
                // System.out.println(node+"-"+insert[node]+"  "+i+"-"+lsi[i]);
                if(insert[node]<lsi[i]){
                    res.add(node+" "+i);
                }
            }
        }
    }
    public static void bridges(int[][] grid){
        List<String> l= new ArrayList<>();
        dfs(grid,0,l,0,0);
        for(String s : l){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row=sc.nextInt();
        insert=new int[row];
        lsi=new int[row];
        vis=new boolean[row];
        int e= sc.nextInt();
        int[][] grid= new int[row][row];
        for(int i=0;i<e;i++){
            int p1=sc.nextInt();
            int p2=sc.nextInt();
            grid[p1][p2]=1;
            grid[p2][p1]=1;
        }
        bridges(grid);
        System.out.println("Try programiz.pro");
    }
}
// import java.io.*;
// import java.util.*;
// import java.util.LinkedList;

// class FindingBridges 
// {
//     private int V;   // No. of vertices    
// 	// Array  of lists for Adjacency List Representation
//     private LinkedList<Integer> adj[];
//     private int[] tim;
//     private int[] lt;
//     int time = 0;

// 	// Constructor
// 	FindingBridges (int v)
//     {
//         V = v;
//         adj = new LinkedList[v];
//         for (int i=0; i<v; ++i)
//             adj[i] = new LinkedList();
//     }

//     // Function to add an edge into the graph
//     void addEdge(int v, int w)
//     {
//         adj[v].add(w);  // Add w to v's list.
//         adj[w].add(v);    //Add v to w's list
//     }
    
//     void dfs(int v ,int p,boolean[] vis,List<String> res){
//         lt[v]=time;
//         tim[v]=time;
//         vis[v]=true;
//         for(int i: adj[v]){
//             if(i!=p){
//                 if(!vis[i]){
//                     time++;
//                     dfs(i,v,vis,res);
//                 }
//                 lt[v]=Integer.min(lt[v],lt[i]);   
//                 if(tim[v]<lt[i]){
//                     res.add(v+" "+i);
//                 }
//             }
//         }
        
//     }
//     // DFS based function to find all bridges
//     void bridge()
//     {   
//         lt=new int[V];
//         tim= new int[V];
//         boolean[] vis=new boolean[V];
//         List<String> res= new ArrayList<>();
//         dfs(0,0,vis,res);
//         for(String s : res){
//             System.out.println(s);
//         }
//     }

//     public static void main(String args[])
//     {      
//         Scanner sc=new Scanner(System.in);
//         int v=sc.nextInt();
//         int e=sc.nextInt();
        
// 		FindingBridges g = new FindingBridges (v);
//         for(int i=0;i<e;i++)
//         {
//             int end1=sc.nextInt();
//             int end2=sc.nextInt();
//             g.addEdge(end1,end2);
//         }
// 		//System.out.println("Bridges in graph");     
//         g.bridge();       
//     }
// }


