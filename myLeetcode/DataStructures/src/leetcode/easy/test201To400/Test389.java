package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 16:59
 **/
public class Test389 {
    public char findTheDifference(String s, String t) {
        int[] charArray = new int[26];
        for(int i=0;i<s.length();i++){
            charArray[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            if(charArray[t.charAt(i)-'a']==0){
                return t.charAt(i);
            }else{
                charArray[t.charAt(i)-'a']--;
            }
        }
        return 'A';
    }
}
