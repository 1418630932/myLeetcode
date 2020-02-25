package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-02
 * @time 16:21
 **/
public class Test70 {
    public static void main(String[] args) {
        System.out.println(2);
    }
    public static int climbStairs(int n) {
        int[] arr =new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for (int i = 2; i <arr.length ; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
