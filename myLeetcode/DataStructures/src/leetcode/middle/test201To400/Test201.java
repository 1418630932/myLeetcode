package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-13
 * @time 15:16
 **/
public class Test201 {
    public static void main(String[] args) {
        int i = rangeBitwiseAnd(2147483646,
                2147483647);
        System.out.println(i);
    }
    public static int rangeBitwiseAnd(int m, int n) {
        int count =0;
        while (m!=n){
            m =m>>1;
            n = n>>1;
            count++;
        }
        return m<<count;
    }
}
