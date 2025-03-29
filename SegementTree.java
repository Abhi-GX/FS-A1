public class SegementTree{
    public static void build(int s,int e, int[] seg,int node,int[] arr){
        if(s==e){
            seg[node]=arr[s];
            return;
        }
        else{
            int mid=(s+e)/2;
            build(s,mid,seg,2*node+1,arr);
            build(mid+1,e,seg,2*node+2,arr);
            seg[node]=Math.max(seg[2*node+1],seg[2*node+2]);
        }
    }
    public static int query(int s, int e, int node,int[] seg,int ss,int ee){
        if(ss==ee || (s==ss && ee==e)){
            return seg[node];
        }else{
            int mid=(ss+ee)/2;
            if(e<=mid){
                return query(s,e, 2*node+1, seg, ss,mid);
            }
            else if(s>=mid+1){
                return query(s,e, 2*node+2, seg, mid+1, ee);
            }else{
                return Math.max(query(mid+1,e, 2*node+2,  seg, mid+1, ee),query(s,mid, 2*node+1, seg, ss,mid));
            }
        }
    }
    public static void update(int[] seg, int s,int e,int node, int i,int v){
        if(i<s || e<i){
            return;
        }
        if(s==e){
            seg[node]+=v;
        }else{
            int mid=(s+e)/2;
            if(i<=mid){
                update(seg, s, mid, 2*node+1, i, v);
            }else{
                update(seg, mid+1, e, 2*node+2, i, v);
            }
            seg[node]=Math.max(seg[2*node+1],seg[2*node+2]);
        }
    }
    public static void main(String[] argv){
        int[] arr= {6,8,3,4,2,9,0};
        int[] seg=new int[2*arr.length+1];
        int node=0;
        build(0,arr.length-1,seg,0,arr);
        int fac=4;
        System.out.println(seg[fac]);
        update(seg, 0, arr.length-1, 0, 5, -1);
        System.out.println(seg[fac]);
        // System.out.println(query(3, 5, 0, seg, 0,arr.length-1));
    }
}