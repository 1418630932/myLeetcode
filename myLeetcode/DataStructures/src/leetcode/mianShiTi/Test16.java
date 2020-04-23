package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-11
 * @time 19:31
 **/
public class Test16 {
    public static void main(String[] args) {
        double v = myPow(2, -4);
        System.out.println(v);
    }
    public static double myPow(double x, int n) {
        long p = n;
        if(p<0){
            x = 1.0/x;
            p = -p;
        }
        double res = 1;
        double target = x;
        while(p>0){
            if((p&1)==1){
                res *=target;
            }
            target = target*target;
            p = p>>1;
        }
        return res;
    }
}
