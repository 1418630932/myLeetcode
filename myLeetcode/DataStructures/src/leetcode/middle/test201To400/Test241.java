package leetcode.middle.test201To400;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-03-22
 * @time 13:54
 **/
public class Test241 {
    public static void main(String[] args) {
        List<Integer> list = diffWaysToCompute("12*3-4*5");
        System.out.println(list);
    }
    static Map<String,List<Integer>> map = new HashMap<>();
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        if (map.containsKey(input))return map.get(input);
        int number = 0;
        for (int i = 0; i <input.length(); i++) {
            List<Integer> list1 = new LinkedList<>();
            List<Integer> list2 = new LinkedList<>();
            if (input.charAt(i)=='+'){
                list1 = diffWaysToCompute(input.substring(0, i));
                list2 = diffWaysToCompute(input.substring(i+1));
                cal(res,list1 ,list2 , input.charAt(i));
            }else if (input.charAt(i)=='-'){
                list1 = diffWaysToCompute(input.substring(0, i));
                list2 = diffWaysToCompute(input.substring(i+1));
                cal(res,list1 ,list2 , input.charAt(i));
            }else if (input.charAt(i)=='*'){
                list1 = diffWaysToCompute(input.substring(0, i));
                list2 = diffWaysToCompute(input.substring(i+1));
                cal(res,list1 ,list2 , input.charAt(i));
            }else {
                number = number*10+input.charAt(i)-48;
            }
        }
        if (res.size()==0)res.add(number);
        map.put(input, res);
        return res;
    }
    public  static void  cal(List<Integer> res ,List<Integer> list1,List<Integer> list2,char param){
        for (int i = 0; i <list1.size() ; i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (param == '+') {
                    res.add(list1.get(i) + list2.get(j));
                } else if (param == '-') {
                    res.add(list1.get(i) - list2.get(j));
                } else if (param == '*') {
                    res.add(list1.get(i) * list2.get(j));
                }
            }
        }
    }
}
