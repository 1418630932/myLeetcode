package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-10
 * @time 14:44
 **/
public class Test258 {
    public static void main(String[] args) {
        System.out.println(26%5%3%2);
    }
    public int addDigits(int num) {
        int res = num;
        while(res>=10){
            int temp =0 ;
            while(res>0){
                temp += res%10;
                res =res/10;
            }
            res =temp;
        }
        return res;
    }
    public int addDigits2(int num) {
        return (num-1)%9+1;
    }
}
