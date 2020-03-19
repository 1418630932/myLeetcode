package leetcode.easy.test801To1000;

/**
 * @author zhuliyang
 * @date 2020-03-18
 * @time 23:39
 *
 * [-257926405,-680763313,702840196,454409669]
 * [-275916328,-417802221,22808107,675629469]
 **/
public class Test836 {
    public static void main(String[] args) {
        boolean rectangleOverlap = isRectangleOverlap(new int[]{-257926405,-680763313,702840196,454409669}, new int[]{-275916328,-417802221,22808107,675629469});
        System.out.println(rectangleOverlap);
    }
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0]>rec2[0]){
            int[] temp = rec1;
            rec1 = rec2;
            rec2 = temp;
        }
        int len1 = Math.abs(rec1[0]-rec1[2]);
        int len2 = Math.abs(rec2[0]-rec2[2]);
        int width1 = Math.abs(rec1[1]-rec1[3]);
        int width2 = Math.abs(rec2[1]-rec2[3]);
        return (long)Math.abs((long)rec1[0]-(long)rec2[2])<(long)len1+(long)len2&&(long)Math.abs((long)rec1[1]-(long)rec2[3])<(long)width1+(long)width2;
    }
}
