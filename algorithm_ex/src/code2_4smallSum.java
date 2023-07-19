public class code2_4smallSum {
    public static int smallSum(int[] arr){
        if(arr==null){
            return 0;
        }
        if(arr.length==1){
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }
    public static int process(int[] arr, int L, int R){
        if(L==R){//意味着只有一个元素，是它本身
            return 0;
        }
        int M=L+(R-L>>1);
        return process(arr, L, M)
        +process(arr, M+1, R)
        +f(arr, L, M, R);
    }
    public static int f(int[] arr, int L, int M, int R){
        int[] help=new int[R-L+1];
        int sum=0;
        int i=0;
        int p1=L;
        int p2=M+1;
        while(p1<=M&&p2<=R){
            if(arr[p1]<arr[p2]){
                help[i++]=arr[p1];
                sum+=arr[p1]*(R-p2+1);
            }else{
                help[i++]=arr[p2++];
            }
            //help[i++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=M){
            help[i++]=arr[p1++];
        }
        while(p2<=R){
            help[i++]=arr[p2++];
        }
        for(int j=0;j<help.length-1;j++){
            arr[L+j]=help[j];
        }
        return sum;
    }

}
