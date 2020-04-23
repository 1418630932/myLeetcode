package leetcode.mianShiTi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhuliyang
 * @date 2020-04-18
 * @time 15:03
 **/
public class Test_jinsai4 {
     static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        System.out.println(minJump(new int[]{2, 5, 1, 1, 1, 1}));
    }
    public static int minJump(int[] jump) {
        boolean[] isVisited =new boolean[jump.length];
        dsf(isVisited,jump,0,1);
        return min;
    }

    private static void dsf(boolean[] isVisited, int[] jump, int index, int count) {
        if (index+jump[index]>=jump.length){
            min = Math.min(min,count );
            return;
        }
        isVisited[index]=true;
        if (index-jump[index]>=0&&!isVisited[index-jump[index]]){
            dsf(isVisited,jump ,index-jump[index] ,count+1 );
        }
        if (index+jump[index]<jump.length&&!isVisited[index+jump[index]]){
            dsf(isVisited,jump ,index+jump[index] ,count+1 );
        }
        isVisited[index]=false;
    }
}
