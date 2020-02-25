package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-22
 * @time 14:53
 **/
public class Test49 {
    public static void main(String[] args) {
//        String string = "aaa";
//        char[] chars = string.toCharArray();
//        chars[0]='0';
//        System.out.println(string);
//
//        HashMap<String,Integer> map = new HashMap<>();
//        map.put(new String(new char[]{'1','2','3'}), 1);
//        map.put(new String(new char[]{'1','2','3'}), 1);
//        System.out.println(map.size());
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr =new String(chars);
            if (map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            }else {
                List<String> list =new LinkedList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        return new LinkedList<>(map.values());
    }
}
