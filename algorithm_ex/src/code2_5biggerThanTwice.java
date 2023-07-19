public class code2_5biggerThanTwice {
    public static int reversePairs(int[] arr){
        if(arr==null||arr.length<2){
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }
    public static int process(int[] arr, int L, int R){
        if(L==R){
            return 0;
        }
        int M=L+(R-L>>1);
        return process(arr, L, M)
                +process(arr, M+1, R)
                +merge(arr, L, M, R);
    }
    public static int merge(int[] arr, int L, int M, int R){
        //L..M M+1..R
        int windowR=M+1;
        int ans=0;

        for (int i = L; i <= M; i++) {
            while(windowR<=R&&(long)arr[i]>(long)(arr[windowR]<<1)) {
//            while (windowR <= R && (long) arr[i] > (long) arr[windowR] * 2) {
                windowR++;
            }

            ans+=windowR-M-1;
        }

        int[] help=new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
////以下代码导致出错
//        int i=help.length-1;
//        int p1=M;
//        int p2=R;
//        while(p1>=L&&p2>=M+1){
//            help[i--]=arr[p1]>arr[p2]*2?arr[p1--]:arr[p2--];
//        }
//        while(p1>=L){
//            help[i--]=arr[p1--];
//        }
//        while(p2>=M+1){
//            help[i--]=arr[p2--];
//        }
//        for (int j = 0; j < help.length; j++) {
//            arr[L+j]=help[j];
//        }
//        return ans;
    }
    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (reversePairs(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
