package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-05
 * @time 13:33
 **/
public class Test43 {
    public static void main(String[] args) {
        int i = countDigitOne(1410065408);
        System.out.println(i);
    }

    public static int countDigitOne(int n) {
        return (int) f(n);
    }

    private static long f(long n) {
        if (n <= 0) return 0;
        long pow = 10;
        while (pow <= n) {
            pow *= 10;
        }
        pow = pow / 10;
        long loop = n / pow;
        long last = n % pow;//当最高位为0时的某尾数字
        if (loop > 1) {
            // 1000~1999(1000+f(999)))
            // + 0~999(f(999))
            // +2000~2999(f(999))
            // +3000~3324(f(324))
            //f(3324) = 1000 +3*f(999)+f(324)
            return pow + loop * f(pow - 1) + f(last);
        } else {
            // 1000~1324(324+1+f(324))
            // + 0~999(f(999))
            //f(1324) = (1324-1000+1)+f(999)
            return last + 1 + f(last) + f(pow - 1);
        }
    }
}
