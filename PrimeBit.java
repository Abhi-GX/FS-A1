import java.util.Scanner;

public class PrimeBit{
    public static boolean prime(int a) {
        if (a < 2) return false;
        if (a == 2) return true; // 2 is the only even prime
        if (a % 2 == 0) return false; // Exclude even numbers
        for (int i = 3; i * i <= a; i += 2) {
            if (a % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] argv){
        Scanner sc= new Scanner(System.in);
        int l= sc.nextInt();
        int r=sc.nextInt();
        int count=0;
        int k=r;
        int total=0;
        while(k>0){
            if((k&1)!=0){
                count++;
            }
            k=k>>1;
        }
        if(prime(count)){
            total++;
        }
        for(int i=r-1;i>=l;i--){
            count--;
            int fac=(i+1)-(i&(i+1));
            if(fac!=0){
                count+=(Math.log(fac)/Math.log(2));
            }
            if(prime(count)){
                total++;
            }
        }
        System.out.println(total);

    }
}