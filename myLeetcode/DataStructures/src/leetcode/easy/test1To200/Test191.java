package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-07
 * @time 16:47
 **/
public class Test191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }
    public static int hammingWeight(int n) {
        int count =0;
        while (n!=0){
            if ((n&1)==1){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }
}
