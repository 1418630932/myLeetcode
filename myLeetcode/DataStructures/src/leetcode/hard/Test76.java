package leetcode.hard;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-05-23
 * @time 0:12
 **/
public class Test76 {
    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
    }
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i <t.length() ; i++) {
            countMap.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (countMap.containsKey(key)){
                if (map.containsKey(key)&&countMap.get(key).equals(countMap.get(key))){
                    remvoe(map,key );
                }
                map.put(key,i );
                if (map.size()==t.length()){
                    Integer peek = peek(map);
                    String substring = s.substring(peek, i+1);
                    res = res.length()==0?substring:res.length()<substring.length()?res:substring;
                }
            }
        }
        return res;
    }
    public static Integer peek(LinkedHashMap<Character, Integer> map){
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            return entry.getValue();
        }
        return null;
    }
    public static void remvoe(LinkedHashMap<Character, Integer> map,Character key){
        Set<Character> set = map.keySet();
        Iterator<Character> iterate = map.keySet().iterator();
        while  (iterate.hasNext()) {
            Character next = iterate.next();
            iterate.remove();
            if (next==key)return;
        }
    }
}
