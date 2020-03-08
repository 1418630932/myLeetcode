package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-08
 * @time 16:04
 **/
public class Test151 {
    public static void main(String[] args) {
        String s = reverseWords("    ");
        System.out.println(s);
    }
    public static String reverseWords(String s) {
        List<StringBuilder> list = new LinkedList<>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)==' ')continue;
            StringBuilder sb = new StringBuilder();
            while (i<s.length()&&s.charAt(i)!=' '){
                sb.append(s.charAt(i++));
            }
            list.add(sb);
        }
        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i)).append(" ");
        }
        return res.length()==0?"": res.deleteCharAt(res.length()-1).toString();
    }
}
