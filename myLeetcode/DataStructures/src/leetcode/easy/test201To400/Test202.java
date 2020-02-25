package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-08
 * @time 14:31
 **/
public class Test202 {
    public static void main(String[] args) {

    }
    public boolean isHappy(int n) {
        //这个是实际测试的，如果想要形成循环，其中循环结果有4.
        //换言之当n等于4以后则意味着进入了死循环
        if(n==4){
            return false;
        }
        int result = 0;
        while(n>0){
            result += Math.pow(n%10,2);
            n = n/10;
        }
        //如果结果不是1则递归。
        return result==1?true:isHappy(result);
    }
}
