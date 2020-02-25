package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-05
 * @time 15:51
 **/
public class Test121 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int value = 0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices[i]<min){
                min=prices[i];//买进
            }else {
                value = Math.max(prices[i]-min,value);//当前卖出或者保持原方案
            }
        }
        return value;
    }
}
