package leetcode.mianShiTi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhuliyang
 * @date 2020-04-18
 * @time 15:40
 **/
public class Testjinsai3 {
    public static void main(String[] args) {
        int[] triggerTime = getTriggerTime(new int[][]{{0,4,5},{4,8,8},{8,6,1},{10,10,0}}, new int[][]{ {12,11,16},{0,0,0},{0,0,0},{10,18,3},{8,14,9}});
        System.out.println(Arrays.toString(triggerTime));
    }
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] res = new int[requirements.length];
        Arrays.fill(res,-1 );
        int[] count = new int[3];
        int c = 0;
        for (int[] anIncrease : increase) {
            c++;
            for (int j = 0; j < increase[0].length; j++) {
                count[j] += anIncrease[j];
            }
            for (int j = 0; j < requirements.length; j++) {
                if (res[j]!=-1)continue;
                boolean falg = true;
                boolean zeroFalg = true;
                for (int k = 0; k < requirements[0].length; k++) {
                    if (requirements[j][k]!=0)zeroFalg =false;
                    if (count[k] < requirements[j][k]) {
                        falg = false;
                        break;
                    }
                }
                if (falg) res[j] = c;
                if (zeroFalg)res[j]=0;
            }
        }
        return res;
    }
}
