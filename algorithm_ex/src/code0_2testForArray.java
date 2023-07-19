public class code0_2testForArray {
    public static void main(String[] args) {
        int[] arr={1,3,2,5,3};
        System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] arr1=new int[4];
        System.arraycopy(arr,1,arr1,0,3);
        System.out.println();
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
//        System.out.println(arr[1:3]);
//        System.out.println(arr[0:arr.length-2]);
    }
}
