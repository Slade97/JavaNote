package digui;

public class Fibonacci {

    //1 1 2 3 5 8 13 21
    //f(n)=f(n-1)+f(n-2)
    private static int[]data;

    public static void main(String[] args) {
        data=new int[46];
        for (int i = 0; i < 45; i++) {
            long start=System.currentTimeMillis();
            System.out.println(i+":"+fab2(i)+"  时间："+(System.currentTimeMillis()-start)+"ms");

        }
    }

    /**
     * 时间复杂度，
     * 每次会有两个分支，大约n次，时间复杂度o[2`n]
     * 每次都会参与运算，空间复杂度和时间复杂度一样
     * */
    public static int fab(int n){
        if(n<2)return 1;
        return fab(n-1)+fab(n-2);
    }

    /**
     * 传统递归的重复性太多了，
     * 把已经计算过的值存起来，如果需要的值已经存在，
     * 则直接使用，而不用再去计算
     * */
    public static int fab2(int n){
        if(n<2)return 1;
        if(data[n]>0) return data[n];
        int res= fab2(n-1)+fab2(n-2);
        data[n]=res;
        return res;
    }
    /**
     * 参数：
     * n肯定有
     * res 当前计算出来的结果
     * pre 上一次运算出来的结果
     * */
    public static int tailFab(int pre,int res,int n){
        if(n<2)return 1;
        return tailFab(res,pre+res,n-1);
    }

    public static int noFab(int n){
        //不用递归
        if(n<2)return 1;
        int f1 =1;
        int f2=1;
        int f3=0;
        for (int i = 3; i <=n ; i++) {
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
    /**
     * 尾递归的阶乘
     * 不用保存中间的结果，把中间的结果带到下一次计算
     * 倒着算，
     * */
    public static int tailFac(int n,int res){
        System.out.println(n+":"+res);
        if(n<=1) return 1;
        return tailFac(n-1,n*res);
    }
}
