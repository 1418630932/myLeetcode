package leetcode.middle.test801To1000;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-06-08
 * @time 23:23
 **/
public class Test990 {
    public static void main(String[] args) {
        equationsPossible(new String[]{"a==b","b!=a"});
    }
    public static boolean equationsPossible(String[] equations) {
        Map<Character,Integer> map = new HashMap<>();
        for (String equation : equations) {
            Character num1 = equation.charAt(0);
            Character num2 = equation.charAt(0);
            Character condition = equation.charAt(2);
            if ('='==condition){
                map.put(num1, 1);
                map.put(num2, 1);
            }
        }
        return false;
    }
}
