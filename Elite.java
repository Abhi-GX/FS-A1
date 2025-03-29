import java.util.ArrayDeque;
import java.util.Deque;

public class Elite{
    public static void main(String[] argv){
        int[] arr= {8,3,1,6,2};
        int l=2;
        int r=3;
        int right=0;
        int left=0;
        Deque<Integer> maxq= new ArrayDeque<>();
        Deque<Integer> minq= new ArrayDeque<>();
        int maxy=0;
        while(right<arr.length){
            while(!maxq.isEmpty() && maxq.peekLast()<=arr[right]){
                maxq.removeLast();
            }
            maxq.addLast(arr[right]);
            while(!minq.isEmpty() && minq.peekLast()>=arr[right]){
                minq.removeLast();
            }
            minq.addLast(arr[right]);
            if(right-left+1>=l){
                maxy=Math.max(maxy,maxq.peekFirst()-minq.peekFirst());
            }
            if(right-left+1>=r){
                left++;
            }else{
                right++;
            }
        }
        System.out.println(maxy);
    }
}