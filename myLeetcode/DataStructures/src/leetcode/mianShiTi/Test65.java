package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-12
 * @time 14:43
 **/
public class Test65 {
    public int add(int a, int b) {
        while (b!=0){
            int temp = a^b; //无进位求和
            b = a&b<<1; //得到进位；
            a= temp;
        }
        return a;
    }
}
