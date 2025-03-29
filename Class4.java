import java.util.*;
public class Class4{
    public static void main(String[] argv){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
       int[] arr= new int[n];
       for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
       }
       HashMap<Integer,List<Integer>> m= new HashMap<>(); 
       for(int i=0;i<n;i++){
        if(m.get(arr[i])==null){
            m.put(arr[i], new ArrayList<>());
        }
        m.get(arr[i]).add(i);
       }
    //    System.out.println(m);
       int miny=100;
       Queue<int[]> q = new LinkedList<>();
       q.offer(new int[]{0,0});
       boolean[] vis= new boolean[n];
       vis[0]=true;
       while(!q.isEmpty()){
        int[] a=q.poll();
        // System.out.println(a[0]+":");
        if(a[0]==n-1){
            miny=Math.min(a[1],miny);
            break;
        }
        if(a[0]+1<n && !vis[a[0]+1]){
            // System.out.println(a[0]+"->"+(a[0]+1));
            q.offer(new int[]{a[0]+1,a[1]+1});
            vis[a[0]+1]=true;
        }
        if(a[0]-1>=0 && !vis[a[0]-1]){
            // System.out.println(a[0]+"->"+(a[0]-1));
            q.offer(new int[]{a[0]-1,a[1]+1});
            vis[a[0]-1]=true;
        }
            if(m.get(arr[a[0]]).size()>1){
                m.get(arr[a[0]]).remove(0);
                if(!vis[m.get(arr[a[0]]).get(0)]){
                    // System.out.println(a[0]+"->"+(m.get(arr[a[0]]).get(0)));
                    q.offer(new int[]{m.get(arr[a[0]]).get(0),a[1]+1});
                    vis[m.get(arr[a[0]]).get(0)]=true;
                }
            }
        
       }
       System.out.println(miny);

    }
}