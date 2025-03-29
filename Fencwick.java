import java.util.*;
public class Fencwick{
    public static int[] tree;
    public static Scanner sc= new Scanner(System.in);
    public static void init(){
        for(int i=0;i<tree.length-1;i++){
            update(i+1,sc.nextInt());
        }
    }
    public static int fetch(int idx){
        int sum=0;
        while(idx>0){
            sum+=tree[idx];
            idx=((~idx+1)&idx)-idx;
        }
        return sum;
    }
    public static void update(int idx,int value){
        while(idx<tree.length){
            tree[idx]+=value;
            idx=((~idx+1)&idx)+idx;
        }
    }
    public static void main(String[] argv){
        int n=sc.nextInt();
        tree= new int[n+1];
        init();
        System.out.println(tree);
        System.out.println(fetch(4));
        update(2,10-tree[2]);
        System.out.println(tree);
        System.out.println(fetch(4));
    }
}