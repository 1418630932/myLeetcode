package leetcode.easy.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-04
 * @time 18:56
 **/
public class Test118 {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i <numRows ; i++) {//行数
            List<Integer> temp = new LinkedList<>();
            for (int j = 1; j <=i+1 ; j++) {//列数
                if (j==1||j==i+1){
                    temp.add(1);
                }else {
                    temp.add(res.get(i-1).get(j-2)+res.get(i-1).get(j-1));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
