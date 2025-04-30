
import java.util.*;
class DistinctIslands {
    static int row;
    static int col;
    static int[] d= {-1,0,1,0,-1};
    public static int[] parent;
    public static String[] pattern;
    public static int[] rank;
    public static int find(int i){
        while(parent[i]>=0){
            i=parent[i];
        }
        return i;
    }
    
    public static void union(int i, int j){
        int pi=find(i);
        int pj=find(j);
        if(rank[pi]>rank[pj]){
            parent[pj]=pi;
        }else if(rank[pi]<rank[pj]){
            parent[pi]=pj;
        }else{
            parent[pi]=pj;
            rank[pi]++;
        }
    }
    public static void dfs(int r, int c,int[][] grid,int rb,int cb){
        pattern[rb*col+cb]+=(r-rb)+" "+(c-cb);
        for(int i=0;i<4;i++){
            int nr=r+d[i];
            int nc=c+d[i+1];
            if(!(nr<0 || nc<0 || nc>=col || nr>=row || grid[nr][nc]==0)){
                grid[nr][nc]=0;
                union(r*col+c,nr*col+nc);
                dfs(nr,nc,grid,rb,cb);
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		row=sc.nextInt();
		col=sc.nextInt();
		int n=row*col;
		parent= new int[n];
		rank= new int[n];
		pattern =new String[n];
		for(int i=0;i<n;i++){
		    parent[i]=-1;
		    rank[i]=1;
		    pattern[i]="";
		}
		int grid[][]=new int[row][col];
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				grid[i][j]=sc.nextInt();
				
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
			  if(grid[i][j]==1){
			      grid[i][j]=0;
			      dfs(i,j,grid,i,j);
			  }  
			}}
		Set<String> s= new HashSet<>();
		for(int i=0;i<n;i++){
		    if(pattern[i]=="") continue;
		    s.add(pattern[i]);
		}
        System.out.println(s.size());
    }
}
