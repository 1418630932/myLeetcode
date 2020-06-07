package leetcode.middle.test801To1000;

/**
 * @author zhuliyang
 * @date 2020-05-27
 * @time 0:39
 **/
public class Test974 {
    public static void main(String[] args) {
        int i = subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(i);
    }
    public static int subarraysDivByK(int[] a, int k) {
        if(a==null || a.length == 0 )return 0;
        int res = 0;
        int[] sum = new int[a.length];
        sum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sum[i] =a[i]+sum[i-1];
        }
        for (int i = 0; i < sum.length; i++) {
            if (sum[i]%k ==0)res++;
            for (int j = 0; j <i ; j++) {
                if ((sum[j]-sum[i])%k ==0){
                    res ++;
                }
            }
        }
        return res ;
    }
}
