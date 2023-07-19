import java.util.Arrays;


public class code3_0101cordmaxpoint {
    public static int maxPoint2(int[] arr, int k){
        int L=0;
        int R=0;
        int max=0;
        try{
            for(;L<=arr.length-1;L++) {
                //        for(;L<=arr.length-1;L++){

                while (R <= arr.length - 1 && arr[R] - arr[L] <= k) {
                    max = Math.max(max, R - L + 1);
                    R++;


                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(arr.toString());
            System.out.println(L);
            System.out.println(R);
        }
        return max;
    }
    public static int maxPoint1(int[] arr, int k){
        int max=0;
        int nearest;
        int last=0;

        while(last<=arr.length-1){
            nearest=nearestIndex(arr, last, arr[last]-k);
            max=Math.max(max,last++-nearest+1);
        }
        return max;
    }
    public static int nearestIndex(int[] arr, int R, int value){
        int L=0;
        int mid;
        mid=L+(R-L>>1);
        while(L<=R){
            if(value>arr[mid]){
                L=mid+1;
            }else{
                R=mid-1;
            }
            mid=L+(R-L>>1);
        }
        return L;
    }

    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println(arr);
                System.out.println(ans2);
                System.out.println(ans3);
                System.out.println("oops!");
                break;
            }
        }

    }

}
