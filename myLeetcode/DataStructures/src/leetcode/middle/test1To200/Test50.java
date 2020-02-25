package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-22
 * @time 15:14
 **/
public class Test50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,8 ));
    }


    public static double myPow(double x, int n) {
        if (x==1)return 1;
        long N =n;
        if (N<0){//负数次方 n先转化为 1/n
            N=-N;
            x= 1/x;
        }
        double res =1;
        double cur =x;
        while (N>0){
            if ((N&1)==1){
                //如果当前二进制位是奇数 多乘一个x
                res = res*cur;
            }
            cur = cur*cur;
            N=N>>1;
        }
        return res;
    }
}
