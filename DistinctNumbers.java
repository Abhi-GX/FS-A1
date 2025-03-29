import java.util.*;
public class DistinctNumbers{
    public static void ans(int[] arr, int k){
        HashMap<Integer,Integer> m= new HashMap<>();
        int d=0;
        for(int i=0;i<k;i++){
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
            if(m.get(arr[i])<=1){
                d++;
            }
        }
        System.out.print(d+" ");
        for(int i=k;i<arr.length;i++){
            if(m.get(arr[i-k])<=1){
                d--;
            }
            m.put(arr[i-k],m.getOrDefault(arr[i-k],0)-1);
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
            if(m.get(arr[i])<=1){
                d++;
            }
            System.out.print(d+" ");
        }
        
    }
    public static void main(String[] argv){
        Scanner sc= new Scanner(System.in);

        
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ans(arr,k);
    }
}