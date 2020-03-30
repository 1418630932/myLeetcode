package leetcode.middle.test801To1000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-03-28
 * @time 16:03
 **/
public class Test820 {
    public static void main(String[] args) {
        String[] words = new String[]{"time", "me", "bell"};
        int i = minimumLengthEncoding(words);
        System.out.println(i);

    }
    public static int minimumLengthEncoding(String[] words) {
        if(words==null||words.length==0)return 0;
        StringBuilder sb = new StringBuilder();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        for (int i = 0; i <words.length ; i++) {
            boolean isContains =false;
            for (int j = 0; j <i ; j++) {
                int p = words[i].length()-1;
                int q = words[j].length()-1;
                while (p>=0&&q>=0){
                    if (words[i].charAt(p)!=words[j].charAt(q))break;
                    p--;q--;
                }
                if (p<0){
                    isContains=true;
                    break;
                }
            }
            if (!isContains){sb.append(words[i]).append("#");}
        }
        return sb.length();
    }
}