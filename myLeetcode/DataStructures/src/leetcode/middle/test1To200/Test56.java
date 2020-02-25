package leetcode.middle.test1To200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-23
 * @time 14:59
 **/
public class Test56 {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(arr);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
//        sort(arr);
//        for (int[] ints : arr) {
//            System.out.println(Arrays.toString(ints));
//        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length==1)return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });//对二维数组按照最小值排序  如果最小值相等 按照最大值排序
        int min = intervals[0][0];
        int max = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>max){
                list.add(intervals[i]);//插入新区间
                min=intervals[i][0];//更新最小值
                max=intervals[i][1];//更新最大值
            }else if (intervals[i][1]>max){
                list.get(list.size()-1)[1]=intervals[i][1];//更新最后的区间最大值
                max = intervals[i][1];//更新最大值
            }
        }
        int[][] res =new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public static void sort(int[][] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j <arr.length ; j++) {
                if (arr[i][0]>arr[j][0]){
                    int[] temp = arr[i];
                    arr[i] =arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
