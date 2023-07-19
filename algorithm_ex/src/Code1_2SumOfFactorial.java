/**
 * 求4！+3！+2！+1！
 * 注意<=，这样才能最终循环到那个数
 */

public class Code1_2SumOfFactorial {
    public static long f1(int num){
        long sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += factorial(i);
        }
        return sum;
    }
    public static long factorial(int N){
        long product = 1;
        for (int index = 1; index <= N; index++) {
            product *= index;
        }
        return product;
    }

    public static long f2(int num){
//        int sum = 0;
//        int factor = 1;
//        for (int i = 1; i <= num; i++) {
//            for (int j = i; j > 0; j--) { //这一步其实就是复制i，所以这个循环可以去掉
//                factor *= j;
//            }
//            sum += factor;
//            factor = 1;// factor一定要注意复位
//        }
//        return sum;
        long sum = 0;
        long cur = 1;
        for (int i = 1; i <= num; i++) {
            cur *= i;
            sum += cur;
        }
        return sum;
    }

    public static void main(String[] args) {
        int N = 10000;
        System.out.println(System.currentTimeMillis());
        System.out.println(f2(N));
        System.out.println(System.currentTimeMillis());
        System.out.println(f1(N));
        System.out.println(System.currentTimeMillis());
    }
}
