package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-21
 * @time 13:28
 **/
public class Test365 {
    public static void main(String[] args) {
        boolean b = canMeasureWater(4, 6, 3);
        System.out.println(b);
    }
    public static boolean canMeasureWater(int x, int y, int z) {
        if (z==0)return true;
        int end = x<y?x:y;
        int maxCommonnumber = 0 ;//最大公约数
        for (int i = 1; i <=end ; i++) {
            if (x%i==0&&y%i==0){
                maxCommonnumber = i;
            }
        }
        return z%maxCommonnumber==0;
    }
}
