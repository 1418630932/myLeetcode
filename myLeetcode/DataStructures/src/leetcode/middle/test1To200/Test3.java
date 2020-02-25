package leetcode.middle.test1To200;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhuliyang
 * @date 2020-02-17
 * @time 21:03
 **/
public class Test3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0)return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int startIndex =0;
        for (int i = 0; i <s.length() ; i++) {
            if (map.containsKey(s.charAt(i))){//出现重复
                startIndex = Math.max(map.get(s.charAt(i))+1,startIndex);
            }
            map.put(s.charAt(i),i );
            max = Math.max(max,i-startIndex +1);
        }
        return max;
    }
}
