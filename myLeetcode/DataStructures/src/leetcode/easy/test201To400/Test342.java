package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-11
 * @time 18:42
 **/
public class Test342 {
    public static void main(String[] args) {
        System.out.println(4>>2);
    }
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        if((num&(num-1))!=0) return false;
        while(num>=4){
            num=num>>>2;
        }
        return num==1;
    }
}
