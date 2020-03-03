package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-03-03
 * @time 15:50
 **/
public class Test137 {
    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 3, 2, 2, 4, 4, 4});
        System.out.println(i);
    }
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i <32 ; i++) {
            int temp =1<<i;
            int count =0;
            for (int j = 0; j <nums.length ; j++) {
                if ((temp&nums[j])!=0){
                    count++;//当前这位二进制位上 出现了几次1
                }
            }
            if (count%3!=0){//如果不是3的倍数 说明出现一次的数当前位上是1
                res|=temp;
            }
        }
        return res;
    }
}
