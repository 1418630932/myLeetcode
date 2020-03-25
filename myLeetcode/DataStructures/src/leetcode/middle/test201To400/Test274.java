package leetcode.middle.test201To400;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-03-25
 * @time 14:14
 **/
public class Test274 {
    public static void main(String[] args) {
        int i = hIndex(new int[]{3, 0, 6, 1, 5});
    }
    public static int hIndex(int[] citations) {
        if (citations==null||citations.length==0)return 0;
        Arrays.sort(citations);
        int[] count = new int[citations[citations.length-1]+1];
        for (int i = 0; i <citations.length ; i++) {
            for (int j = 1; j <=citations[i] ; j++) {
                count[j]++;
            }
        }
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i]>=i)return i;
        }
        return 0;
    }
}
