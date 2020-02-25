package alibaba;

import java.time.temporal.Temporal;

/**
 * @author zhuliyang
 * @date 2019-12-01
 * @time 13:22
 **/
public class ExchangeActivities {
    public static void main(String[] args) {
        System.out.println(result(3, 4, 2, 30));
    }

    public static int result(int price, int rate1, int rate2, int money) {
        int count = money / price; //喝到的瓶数
        int num1 = count;//瓶盖数
        int num2 = count;//空瓶数
        //瓶盖数>=4 或者空瓶数>=2 表示又可以进行兑换了
        while (num1 >= rate1 || num2 >= rate2) {
            int temp = 0;//兑换的瓶数
            temp += num1 / rate1;//瓶盖兑换的瓶数
            temp += num2 / rate2;//瓶子兑换的瓶数
            count+=temp;//喝到的瓶数
            //兑换的又喝完之后
            num1=num1%rate1+temp;//剩下的瓶盖
            num2=num2%rate2+temp;//剩下的空瓶
        }
        return count;
    }
}
