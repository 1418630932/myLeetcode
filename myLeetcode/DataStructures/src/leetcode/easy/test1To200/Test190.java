package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-07
 * @time 17:01
 **/
public class Test190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
//        System.out.println(!(10&(10-1)));
    }
    public static int reverseBits(int n) {
        int res=0;
        int temp =0;
        for (int i = 0; i <32 ; i++) {
            temp = n&1;
            res = (res<<1)+temp;
            n=n>>>1;
        }
        return res;
    }
}
