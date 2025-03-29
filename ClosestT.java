import java.util.*;
public class ClosestT{
    public static void main(String[] argv){
        Scanner sc= new Scanner(System.in);
        int n1=sc.nextInt();
        int[] arr1=new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int[] arr2=new int[n2];
         for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        int n3=sc.nextInt();
        int[] arr3=new int[n3];
         for(int i=0;i<n3;i++){
            arr3[i]=sc.nextInt();
        }
        int tar=sc.nextInt();
        int[] arr4= new int[3];
        int min=Integer.MAX_VALUE;
        for(int i : arr1){
            int tar2=tar-i;
            int j=0;
            int k=arr3.length-1;
            while(j<arr2.length && k>=0){
                int dif=(arr2[j]+arr3[k])-tar2;
                if(Math.abs(dif) <min){
                    // System.out.println(min+" "+dif);
                    min=Math.abs(dif);
                    arr4[0]=i;
                    arr4[1]=arr2[j];
                    arr4[2]=arr3[k];
                }
                if(dif>=0){
                    k--;
                }else{
                    j++;
                }
            }

        }
        System.out.println(arr4[0]+" "+arr4[1]+" "+arr4[2]);
    }
}
// You are given an integer array nums of length n and an integer target. 
// Your task is to find three integers in nums such that their sum is closest to the given target.

// Return the sum of these three integers.

// You may assume that each input would have exactly one solution.

// Input Format:
// -------------
// Line-1: An integer n, the size of the array.
// Line-2: n space-separated integers representing the elements of the array nums.
// Line-3: A single integer target.

// Output Format:
// --------------
// Line-1: Print a single integer, representing the sum of three integers closest to the target.

// Sample Input-1:
// ---------------
// 4
// -1 2 1 -4
// 1

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 3
// 0 0 0
// 1

// Sample Output-2:
// ----------------
// 0


