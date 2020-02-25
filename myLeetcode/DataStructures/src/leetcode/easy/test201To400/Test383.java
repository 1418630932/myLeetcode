package leetcode.easy.test201To400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 15:46
 **/
public class Test383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <magazine.length() ; i++) {
            if (!map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i), 1);
            }else {
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1 );
            }
        }
        for (int i = 0; i <ransomNote.length() ; i++) {
           if (!map.containsKey(ransomNote.charAt(i))||map.get(ransomNote.charAt(i))==0){
               return false;
           }else {
               map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1 );
           }
        }
        return true;
    }
}
