package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-01-30
 * @time 14:57
 **/
public class Test9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int temp =x;
        int res =0;
        while (x!=0){
            int tail = x%10;
            res = res*10+tail;
            x=x/10;
        }
        return temp==res;
    }
}
