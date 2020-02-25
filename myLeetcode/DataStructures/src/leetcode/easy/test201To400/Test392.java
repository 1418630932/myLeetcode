package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 18:14
 **/
public class Test392 {
    public boolean isSubsequence(String s, String t) {
        if(s==null||s.length()==0)return true;
        int index =0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(index)){
                index++;
            }
            if(index==s.length())return true;
        }
        return false;
    }
}
