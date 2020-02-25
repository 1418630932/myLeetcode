package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-05
 * @time 16:21
 **/
public class Test125 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("Zeus was deified, saw Suez.");
        System.out.println("Zeus was deified, saw Suez.".charAt(24));
        System.out.println(palindrome);
        System.out.println('0'&0xDF);
        System.out.println('a'&0xDF);
        System.out.println('A' +0);
//        System.out.println('C'+0);
//        System.out.println('c'+0);
    }
    public static boolean isPalindrome(String s) {
        if (s==null||s.length()==0)return true;
        int i =0;
        int j= s.length()-1;
        while (i<j){
            while (!isValid(s.charAt(i))){
                i++;
                if (i==s.length()){return false;}
            }
            while (!isValid(s.charAt(j))){
                j--;
                if (j==-1){return false;}
            }
            if ((s.charAt(i)&0xDF)!=(s.charAt(j)&0xDF)){
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }
    public static boolean isValid(char c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9');
    }
}
