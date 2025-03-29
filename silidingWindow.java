import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class silidingWindow{
    public static void main(String[] argv){
        int[] arr={1,2,3,1,2,3,1,2};
        int n=arr.length;
        int maxarea=10;
        int maxfreq=2;
        int idx=0;
        int area=0;
        int maxlength=0;
        HashMap<Integer,Integer> m= new HashMap<>();
        for(int i=0;i<n;i++){
            area=area+arr[i];
            m.put(arr[i],m.getOrDefault(arr[i], 0)+1);
            while(m.get(arr[idx])>maxfreq || area>maxarea){
                area-=arr[idx];
                m.put(arr[i],m.getOrDefault(arr[idx], 0)-1);
                idx++;
            }
            System.out.println(area+" "+maxlength);
            maxlength=Math.max(maxlength,i-idx+1);
        }
        System.out.println(maxlength);
        // int[] arr={10,12,14,11,15};
        // int k=3;
        // Deque pp= new ArrayDeque<>();
        // for(int i=0;i<k;i++){
        //     while(!pp.isEmpty() && arr[i]<=arr[(int)pp.peekLast()]){
        //         pp.removeLast();
        //     }
        //     pp.addLast(i);
        // }
        // System.out.println(arr[(int)pp.peekFirst()]);
        // for(int i=k;i<arr.length;i++){
        //     while(!pp.isEmpty() && i-k>=(int)pp.peekFirst()){
        //         pp.removeFirst();
        //     }
        //     while(!pp.isEmpty() && arr[i]<=arr[(int)pp.peekLast()]){
        //         pp.removeLast();
        //     }
        //     pp.addLast(i);
        //     System.out.println(arr[(int)pp.peekFirst()]);
        // }
        // PriorityQueue pp= new PriorityQueue<>();
        // for(int i=0;i<k;i++){
        //     pp.add(arr[i]);
        // }
        // System.out.println(pp.peek());
        // for(int i=k;i<arr.length;i++){
        //     int peeku=(int) pp.peek();
        //     if(peeku==arr[i-k]){
        //         pp.poll();
        //     }
        //     pp.add(arr[i]);
        //     System.out.println(pp.peek());
        // }
    }
}