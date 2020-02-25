package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-01
 * @time 18:05
 **/
public class Test58 {
    public static void main(String[] args) {
        int hello_world = lengthOfLastWord("Hello World      ");
        System.out.println(hello_world);
    }
    public static int lengthOfLastWord(String s) {
        int count=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)!=' '){
                count++;
            }else if (s.charAt(i)==' '&&count!=0){
                break;
            }
        }
        return count;
    }
}
