package leetcode.mianShiTi;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-30
 * @time 12:18
 **/
public class Test62 {
    public static void main(String[] args) {
        int i = lastRemaining(5, 3);
        System.out.println(i);
    }
    public static int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int start = 0;
        while(list.size()>1){
            int index = (m+start-1)%list.size();
            list.remove(index);
            start = index==list.size()?0:index;
        }
        return list.get(0);
    }


}
