package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-28
 * @time 17:07
 **/
public class Test120 {
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        int i = minimumTotal(list);
        System.out.println(i);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j <triangle.get(i).size() ; j++) {
                Integer num1 = triangle.get(i + 1).get(j);
                Integer num2 = triangle.get(i + 1).get(j+1);
                triangle.get(i).set(j,Math.min(num1,num2 )+triangle.get(i).get(j) );
            }
        }
        return triangle.get(0).get(0);
    }
}
