package leetcode.easy.test1To200;

import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-01-30
 * @time 15:01
 **/
public class Test13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int res =0;
        for (int i = 0; i <s.length() ; i++) {
            if (i<s.length()-1&&map.get(s.substring(i,i+2))!=null){
                res = res+map.get(s.substring(i,i+2));
                i++;
            }else {
                res = res+map.get(s.substring(i,i+1));
            }
        }
        return res;
    }
}
