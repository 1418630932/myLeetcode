package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-07
 * @time 15:13
 **/
public class Test172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
    }
    public static int trailingZeroes(int n) {
//        int count =0;
//        for (int i = 5; i <=n ; i+=5) {
//            int temp =i;
//            while (temp%5==0){
//                if (temp%5==0){count++;}
//                temp=temp/5;
//            }
//        }
//        return count;
        int count =0;
        while (n/5>=5){
            count+=n/5;
            n=n/5;
        }
        return count;
    }
}
