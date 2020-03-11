package leetcode.middle.test1To200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test187 {
    public static void main(String[] args) {
        List<String> aaaaaaaaaaa = findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(aaaaaaaaaaa);
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String cur = s.substring(i, i + 10);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
