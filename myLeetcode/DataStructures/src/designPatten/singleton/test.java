package designPatten.singleton;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-02-25
 * @time 23:53
 **/
public class test {
    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(15);
        for (int[] ints : continuousSequence) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for(int i=1;i<target/2+1;i++){
            int sum = target;
            int temp = i;
            int length =0;
            while(sum>0){
                sum -= temp++;
                length++;
            }
            if(sum ==0){
                int[] arr = new int[length]; int start =i;
                for (int j = 0; j <length ; j++) {
                    arr[j] = start++;
                }
                res.add(arr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
