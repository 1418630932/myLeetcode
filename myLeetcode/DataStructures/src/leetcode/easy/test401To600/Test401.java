package leetcode.easy.test401To600;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 18:15
 **/
public class Test401 {
    public static void main(String[] args) {

    }
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i <12 ; i++) {
            for (int j = 0; j <59 ; j++) {
                if (oneCount(i)+oneCount(j)==num){
                    res.add(i+":"+(j<10?"0"+j:j));
                }
            }
        }
        return res;
    }
    public int oneCount(int n){
        int res = 0;
        while (n!=0){
            n = n&(n-1);
            res++;
        }
        return res;
    }
}
