public class VariableSizeWindow{
    public static void main(String[] argv){
        int[] arr= {1,6,2,1,4,1,1,1};
        int k=8;
        int left=0;
        int sum=0;
        int maxy=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            // System.out.println(sum);
            if(sum>k){
                sum=arr[i];
                maxy=Math.max(i-left+1,maxy);
                left=i;
            }
        }
        System.out.println(maxy);
    }
}