// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Heap {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int v){
            val=v;
        }
    }
    public static class MaxHeap{
        ArrayList<Integer> arr;
        
        MaxHeap(){
            arr= new ArrayList<>();
        }
        public void swap(int a, int b){
            int t=arr.get(a);
            arr.set(a,arr.get(b));
            arr.set(b,t);
        }
        public int pop(){
            int v=arr.get(0);
            int la=arr.size()-1;
            arr.set(0,arr.get(la));
            arr.remove(arr.size()-1);
            la=0;
            int nn=arr.size()-1;
            while(la<=nn){
                int l=la*2+1;
                int r=la*2+2;
                if(l>nn && r>nn){
                    break;
                }else if(r>nn){
                    swap(l,la);
                    la=l;
                }else if(l>nn){
                    swap(r,la);
                    la=r;
                }else{
                    if(arr.get(l)>arr.get(r)){
                        swap(l,la);
                        la=l;
                    }else{
                        swap(r,la);
                        la=r;
                    }
                }
            }
            
            return v;
        }
        public int parent(int n){
            return (n-1)/2;
        }
        public void insert(int n){
            arr.add(n);
            int la=arr.size()-1;
            while(arr.get(la)>arr.get(parent(la))){
                swap(la,parent(la));
                la=parent(la);
            }
        }
        public void print(){
            System.out.println(arr);
        }
    }
    public static void main(String[] args) {
        MaxHeap m= new MaxHeap();
        int[][] scores = new int[5][];
        m.insert(7);
        m.insert(3);
        m.insert(10);
        m.insert(5);
        m.print();
        System.out.println(m.pop());
        m.print();
        System.out.println(m.pop());
        m.print();
        System.out.println(m.pop());
        m.print();
    }
}