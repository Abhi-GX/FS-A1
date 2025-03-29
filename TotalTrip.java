import java.util.Scanner;

public class TotalTrip{
    public static int trips(int mid,int[] arr){
        int count=0;
        for(int i : arr){
            if(i<=mid){
                count+=mid/i;
            }
        }
        return count;
    }
    public static void main(String[] argv){
        // Scanner sc= new Scanner(System.in);
        // int n=sc.nextInt();
        // int[] arr= new int[n];
        // int sum=0;
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        //     sum+=arr[i];
        // }
        // int tar=sc.nextInt();
        // int count=0;
        // int i=0;
        // while(tar>count){
        //     count+=i+1;
        //     i++;
        // }
        // System.out.println(arr[i-1]);
        int n=3;
        String s=n+5+" ";
        System.out.println(s);
        // int i=0;
        // int j=sum;
        // while(i<j){
        //     int mid=(i+j)>>1;
        //     if(trips(mid,arr)>= tar){
        //         j=mid;
        //     }else{
        //         i=mid+1;
        //     }
        // }
        // System.out.println(j);

    }
}