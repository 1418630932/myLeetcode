package leetcode.mianShiTi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-04-10
 * @time 13:04
 **/
public class Test38 {
    public static void main(String[] args) {
        String[] abcs = permutation("abca");
        System.out.println(Arrays.toString(abcs));
    }
    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> res = new LinkedList<>();
        boolean[] isVisited = new boolean[chars.length];
        helper(res,"",chars,isVisited);
        return res.toArray(new String[]{});
    }

    private static void helper(List<String> res, String s, char[] chars, boolean[] isVisited) {
        if (s.length()==chars.length){
            res.add(s);
        }
        for (int i = 0; i <chars.length ; i++) {
            if (!isVisited[i]){
                if (i>0&&!isVisited[i-1]&&chars[i]==chars[i-1])continue;
                isVisited[i]=true;
                helper(res,s+chars[i] ,chars ,isVisited);
                isVisited[i]=false;
            }
        }
    }
}
