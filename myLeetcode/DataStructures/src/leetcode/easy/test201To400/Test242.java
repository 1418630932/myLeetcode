package leetcode.easy.test201To400;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 23:23
 **/
public class Test242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1 );
            }
        }
        for (int i = 0; i <t.length() ; i++) {
            if (!map.containsKey(t.charAt(i))){
                return false;
            }else {
                map.put(t.charAt(i),map.get(t.charAt(i))-1 );
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()<0){return false;}
        }
        return true;
    }
}
