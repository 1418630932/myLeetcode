package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-05
 * @time 15:55
 **/
public class Test122 {
    public static void main(String[] args) {
        int i = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(i);
    }
    public  static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int amount = 0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices[i]<min){
                min=prices[i];
            }else {
                if (prices[i]-min>0){//有利可图
                    amount+=prices[i]-min;
                    min=prices[i];//当天再次买进
                }
            }
        }
        return amount;
    }
}
