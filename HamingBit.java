import java.util.Scanner;

public class HamingBit{
    public static void main(String[] argv){
        Scanner sc = new Scanner (System.in);
        int n= sc.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<32;i++){
            int c1=0;
            for(int num : arr){
                if(((num>>i) & 1) !=0){
                    c1++;
                }
            }
            sum+=(n-c1)*c1;
        }
        System.out.println(sum);
    }
}