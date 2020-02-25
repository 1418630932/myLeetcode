package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-08
 * @time 15:11
 **/
public class Test204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(3&1);
    }
    public static int countPrimes(int n) {
        int count =1;
        for (int i = 3; i <n ; i++) {
            if ((i&1)==1){
                for (int j = 2; j <i ; j++) {
                    if (i%j==0){
                        count++;
                        break;
                    }
                }
            }else {//偶数
                count++;
            }
        }
        return n-count-1;
    }
}
