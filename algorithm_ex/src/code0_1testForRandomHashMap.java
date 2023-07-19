import java.util.HashMap;

//just for a random test
public class code0_1testForRandomHashMap {
    public static void main(String[] args) {
        int maxValue=6;
        HashMap<Integer, Integer> hashmap=new HashMap<>();
        int[] arr=new int[100];
//        hashmap.put(1,200);
//        System.out.println(hashmap.containsKey(1));
//        System.out.println(hashmap);
//        HashMap hashmap1= (HashMap) hashmap.clone();
//        System.out.println(hashmap1);
//        System.out.println(hashmap.isEmpty());
//        System.out.println(hashmap.size());
//        System.out.println(hashmap.clone());
//        System.out.println(hashmap.containsValue(1));
//        System.out.println("---------------");
//        System.out.println(hashmap.entrySet());
//        System.out.println(hashmap.get(1)+1);
//        System.out.println("1"+hashmap.replace(1,3));
//        System.out.println("2"+hashmap);
//        System.out.println("3"+hashmap.replace(1,1,5));
//        System.out.println("4"+hashmap);
//        System.out.println("5"+hashmap.remove(1));
//        System.out.println("6"+hashmap);
        //生成一个hashmap，把出现的随机数及次数统计进去
        int tmp;
        for (int i = 0; i < 100; i++) {
            tmp=(int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if(hashmap.containsKey(tmp)){
                hashmap.replace(tmp,hashmap.get(tmp)+1);
            }else{
                hashmap.put(tmp, 1);
            }
//            arr[i]=(int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
//            System.out.println();
        }
        System.out.println(hashmap);//{0=16, -1=11, 1=15, -2=10, 2=12, -3=5, 3=8, -4=5, 4=9, -5=1, 5=6, 6=2}
    }
}
