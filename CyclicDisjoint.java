
import java.util.*;
public class CyclicDisjoint{
    public static int[] parent;
    public static int find(int i){
        if(i!=parent[i]){
            parent[i]=find(parent[i]);
        }
        return i; 
    }
    public static boolean union(int i, int j){
        int pi=find(i);
        int pj=find(j);
        if(pi==pj){
            return true;
        }else{
            if(pi>pj){
                parent[pi]=pj;
            }else{
                parent[pj]=pi;
            }
            return false;
        }
    }
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        parent= new int[n];
        int e=sc.nextInt();
        for(int i=0;i<e;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(union(a,b)){
                System.out.println("Cycle_Found");
                return;
                // break;
            }
        }
        System.out.println(" No_Cycle_Found");
    }
}
