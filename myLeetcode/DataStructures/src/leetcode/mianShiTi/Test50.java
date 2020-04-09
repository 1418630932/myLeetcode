package leetcode.mianShiTi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-04-08
 * @time 13:21
 **/
public class Test50 {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                map.put(aChar, map.get(aChar)+1);
            }else {
                map.put(aChar,1 );
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1)return entry.getKey();
        }
        return ' ';
    }
}
