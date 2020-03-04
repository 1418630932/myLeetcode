package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-04
 * @time 13:30
 **/
public class Test139 {
    public static void main(String[] args) {
        boolean b = wordBreak1("bb", Arrays.asList("a", "b","and","sand"));
        System.out.println(b);
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];//表示从起点到第i位字符是否可以被拆分
        int maxLength = 0;//wordDict的最长字符串长度
        for (String word : wordDict) {
            maxLength = Math.max(word.length(),maxLength );
        }
        dp[0] = true;
        for (int i = 1; i <dp.length ; i++) {
            for (int j = Math.max(0, i-maxLength); j <i ; j++) {
                if (j>=0&&dp[j]&&wordDict.contains(s.substring(j,i))){//前者可以被拆分 并且后者在字典中包含
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }


    //超时
    public static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict , 0);
    }
    //paramter:  word代表本次要比对的字典中的单词
    public static boolean helper(String s,List<String> wordDict,int startIndex){
        if (startIndex==s.length())return true;//匹配完成
        boolean res =false;
        for (int i =0 ; i <wordDict.size() ; i++) {
            String word = wordDict.get(i);
            if (startIndex+word.length()<=s.length()&&word.equals(s.substring(startIndex, startIndex+word.length()))){
                res |= helper(s,wordDict ,startIndex+word.length());
            }
        }
        return  res;
    }
}
