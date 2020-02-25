package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-11
 * @time 18:33
 **/
public class Test326 {
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        while(n%3==0){
            n=n/3;
        }
        return n==1;
    }
}
