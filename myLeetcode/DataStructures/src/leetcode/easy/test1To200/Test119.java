package leetcode.easy.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-05
 * @time 15:11
 **/
public class Test119 {
    public static void main(String[] args) {
        System.out.println();
    }
    public  List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <rowIndex+1 ; i++) {//行数
            List<Integer> temp = new LinkedList<>();
            for (int j = 1; j <=i+1 ; j++) {//列数
                if (j==1||j==i+1){
                    temp.add(1);
                }else {
                    temp.add(res.get(j-2)+res.get(j-1));
                }
            }
            res=temp;
        }
        return res;
    }
}
