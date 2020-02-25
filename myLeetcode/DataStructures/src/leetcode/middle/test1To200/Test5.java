package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-17
 * @time 22:07
 **/
public class Test5 {
    public static void main(String[] args) {
        longestPalindrome1("aaaa");
    }
    public static String longestPalindrome(String s) {
        if (s==null||s.length()==0)return s;
        String res = "";
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i; j <s.length() ; j++) {
                if (res.length()>=j-i+1)break;
                if (isPalindrome(s,i ,j )){
                    res = res.length()>=j-i+1?res:s.substring(i, j+1);
                }
            }
        }
        return res;
    }
    public static boolean isPalindrome(String s ,int i,int j){
        while (i<=j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }


    public static String longestPalindrome1(String s){
        if (s==null||s.length()==0)return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for (int len = 1; len <=s.length() ; len++) { //以i为起点
            for (int start = 0; start <s.length() ; start++) {//长度为length的串
                int end = start+len-1;
                if (end >= s.length()) //下标已经越界，结束本次循环
                    break;
                //start==end 单个字符  end-start==1 两个字符  p[start+1][end-1]其他情况
                if ((end==start||end-start==1|| dp[start+1][end-1])&&s.charAt(start)==s.charAt(end)){
                    dp[start][end]=true;
                }else {
                    dp[start][end]=false;
                }
                if (dp[start][end]&&end-start>res.length()-1){//判断是否最大
                    res = s.substring(start,end +1);
                }
            }
        }
        return res;
    }

}
