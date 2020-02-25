package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 15:02
 **/
public class Test371 {
    public static void main(String[] args) {
        int sum = getSum(-2, 2);
        System.out.println(-214748364);
        System.out.println(sum);
    }
    public static int getSum(int a, int b) {
        double res1 = Math.pow(2,a );
        double res2 = Math.pow(2,b );
        return (int) (Math.log(res1*res2)/Math.log(2));
    }
}
