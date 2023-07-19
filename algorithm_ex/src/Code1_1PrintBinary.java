/**
 * 把一个数转化为二进制打印出来
 */
public class Code1_1PrintBinary {
    public static void printBinary(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1<<i)) == 0 ? "0" : "1");//关键是顺序、括号
            //因为num&(1<<i)可能的情况包括0、1、2等，所以等于0就取0，不等于0就取1
        }
        System.out.println();
    }
    //把十进制写入二进制数，这个暂时还没能实现。原因是十进制、二进制都是数的一种形式。
    public static void D2B(int num){
        for (int i = 31; i >= 0; i--) {
            String a = (num & (1<<i)) == 0 ? "0" : "1";
            System.out.println(a);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        printBinary(2);
        printBinary(10);
        printBinary(63);
    }
}
