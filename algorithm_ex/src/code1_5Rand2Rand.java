public class code1_5Rand2Rand {
    public static int f(){
        int ans = (int)(Math.random()*5+1);
//        System.out.println(ans);
        return ans;//[0,5)强转int为[0,4]，再+1得[1,5]
    }
    public static int a1(){
        int ans;
        do{
            ans = f();//循环体里面写成ans = f()<3?0:1，会导致只返回0或者1
        }while(ans==3);
//        return ans = f()<3?0:1;
        return ans<3?0:1;//如果写成return ans = f()<3?0:1，那么【又会跑一遍f()！！！0的频率是0.4,1的频率是0.6】，同时ans也被忽略
    }
    public static int a2(){
        //这么写，会导致ans要么为0，要么为32（tem=1的时候）
//        int tem = a1();
//        int ans = tem<<2+tem<<1+tem;
        //这么写，会导致ans出现0（0.5）、8（0.125）、16（0.25）、32（0.125）
//        int ans = a1()<<2+a1()<<1+a1();
        //这样写才对
        int ans = (a1()<<2)+(a1()<<1)+a1();
        return ans;

    }
    public static int a3(){
        int ans;
        do{
            ans=a2();
        }while(ans==7);
//        System.out.println(ans);
        return ans;
    }
    public static int a4(){
        return a3()+1;
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        // Math.random() -> double -> [0,1)
        //

        int testTimes = 100000;
        int count = 0;
        int[] counts;
        counts = new int[100];
        for (int i = 0; i < testTimes; i++) {
            int num = a4();
            counts[num]++;
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }

//        int N = 100;
//        int[] arr = new int[6];
//        for (int i = 1; i < N; i++) {
//
//        }
////        System.out.println(f());
//        System.out.println(a1());
//        System.out.println(a2());
//        System.out.println(a3());
//        System.out.println(a4());
    }
}
