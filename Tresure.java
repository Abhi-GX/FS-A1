import java.util.HashMap;
import java.util.PriorityQueue;

public class Tresure{
    public static void main(String[] argv){
        int k=5;
        int f=2;
        int x=2;
        int[] arr={1 ,2 ,3, 1, 2, 2, 3, 4};
        PriorityQueue pq= new PriorityQueue<>();
        HashMap<Integer,Integer> m= new HashMap<>();
        for(int i=0;i<k;i++){
            if(m.get(arr[i])!=null){

            }
            m.put(arr[i],m.getOrDefault(arr[i], 0)+1);
        }
    }
}