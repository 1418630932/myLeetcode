package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-01-30
 * @time 14:26
 **/
public class Test7 {
    public static void main(String[] args) {
        System.out.println(reverse(1234567898));
    }
    public static int reverse(int x) {
        int res =0;
        while (x!=0){
            int tail = x%10;
            res = res*10+tail;
            x=x/10;
            if (res>Integer.MAX_VALUE/10&&x!=0){
                return 0;
            }
            if (res<Integer.MIN_VALUE/10&&x!=0){
                return 0;
            }
        }
        return res;
    }
}
