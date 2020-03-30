package leetcode.middle.test201To400;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-03-30
 * @time 13:11
 **/
public class Test318 {
    public static void main(String[] args) {
        int i = maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
        System.out.println(i);
    }
    public static int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i <words.length ; i++) {
            for (int j = i+1; j <words.length ; j++) {
                int[] arr = new int[26];
                for (int k = 0; k <words[i].length() ; k++) {
                    arr[words[i].charAt(k)-97]++;
                }
                boolean flag = true;
                for (int t = 0; t <words[j].length() ; t++) {
                    if (arr[words[j].charAt(t)-97]!=0){
                        flag =false;
                        break;
                    }
                }
                if (flag){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }

        }
        return max;
    }
}
