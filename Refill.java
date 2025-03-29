import java.util.*;
public class Refill{
    public static void main(String[] argv){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        int an=sc.nextInt();
        int bn=sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int i=0;
        int j=n-1;
        int ra=an;
        int rb=bn;
        int refill=0;
        while(i<j){
            if(ra<arr[i]){
                ra=an;
                refill++;
            }
            if(rb<arr[j]){
                rb=bn;
                refill++;
            }
            ra=ra-arr[i];
            rb=rb-arr[j];
            i++;
            j--;
        }
        if(i==j){
            if(Math.max(ra,rb)<arr[i]){
                refill++;
            }
        }
        System.out.println(refill);

    }
}