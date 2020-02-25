package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 15:29
 **/
public class Test374 {
    public static void main(String[] args) {
        System.out.println( guessNumber(10));
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left<=right){
            int mid = right-(right-left)/2;
            if (guess(mid)==-1){
                right = mid-1;
            }else if (guess(mid)==1){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static int guess(int num){
        if (num==6) return 0;
        if (num<6) return -1;
        return 1;
    }
}
