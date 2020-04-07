package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-05
 * @time 14:29
 **/
public class Test44 {
    public static void main(String[] args) {
        int nthDigit = findNthDigit(1000000000);
        System.out.println(nthDigit);
    }
    public static int findNthDigit(int n) {
        if (n<10)return n;
        long nl = n-9;
        long start = 2;
        long pow =90;
        while (nl>start*pow){
            nl -=start*pow;//剩余的位数
            start++;
            pow *=10;
        }
        int startNum = (int) Math.pow(10, start-1);
        long move = (nl-1)/start;//移动了多少个数字
        long tail = (nl-1)%start;//剩下需要移动的位数
        return (startNum+move+"").charAt((int) tail)-48;
    }
}
