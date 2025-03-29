import java.util.*;
public class Fencwick{
    public static int[] tree;
    public static int[] arr;
    public static Scanner sc= new Scanner(System.in);
    public static void init(){
        for(int i=0;i<arr.length;i++){
            update(i+1,arr[i]);
        }
    }
    public static int fetch(int idx){
        int sum=0;
        while(idx>0){
            sum+=tree[idx];
            System.out.println(idx+" "+sum);
            idx=idx-((~idx+1)&idx);
        }
        return sum;
    }
    public static void update(int idx,int value){
        while(idx<tree.length){
            tree[idx]+=value;
            idx=((~idx+1)&idx)+idx;
        }
    }
    public static void print(){
        for(int i : tree){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] argv){
        int n=sc.nextInt();
        arr= new int[n];
        tree= new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        init();
        print();
        System.out.println(fetch(4));
        int idx=2;
        update(idx,10-arr[idx-1]);
        arr[idx]=10;
        print();
        System.out.println(fetch(4));
    }
}