package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-01-30
 * @time 15:39
 **/
public class Test14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        for (int i = 0; i <strs[0].length() ; i++) {
            for (int j = 1; j <strs.length ; j++) {
                //达到最短字符串长度或者出现字符串不匹配
                if (strs[j].length()==i||strs[0].charAt(i)!=strs[j].charAt(i)){
                    return strs[0].substring(0,i );
                }
            }
        }
        return strs[0];
    }
}
