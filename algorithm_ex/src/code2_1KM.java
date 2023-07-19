public class code2_1KM {
    public static int KM(int[] arr, int k, int m){
        int vol=0;
        int max = getMaxNum(arr);
        int J=0;
        while((max>>J)!=0){
            vol++;
            J++;
        }
        int[] volume=new int[vol];
        for(int i=0;i<volume.length;i++){//时间复杂度O(vol*n)
            for (int j = 0; j < arr.length; j++) {
                volume[i] += (arr[j]>>i)&1;
            }
        }
        int ans=0;
        for (int i = 0; i < volume.length; i++) {//时间复杂度O(vol)
            if(volume[i]%m!=0){
                ans|=1 << i;
            }
        }

        return ans;
    }

    public static int getMaxNum(int[] arr){//时间复杂度O(N)
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,2,3,3,3,5,5};
        System.out.println(KM(arr,2,3));
        arr= new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 0, 0};
        System.out.println(KM(arr,2,3));
    }
}
