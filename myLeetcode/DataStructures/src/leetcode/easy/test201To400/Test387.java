package leetcode.easy.test201To400;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 16:32
 **/
public class Test387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1 );
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        for (int i = 0; i <s.length() ; i++) {
            if (map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
