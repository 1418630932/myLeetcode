package leetcode.easy.test1To200;

import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-01-31
 * @time 16:03
 **/
public class Test20 {
    public static void main(String[] args) {
        System.out.println(isValid1("([][][][]])"));

    }
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (!stack.isEmpty()&&(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}')){
                if (s.charAt(i)-stack.peek()==1||s.charAt(i)-stack.peek()==2){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = sb.length()-2; i >=0 ; i--) {
            if (sb.charAt(i)=='('||sb.charAt(i)=='['||sb.charAt(i)=='{'){
                if (sb.charAt(i)-sb.charAt(i+1)==-1||sb.charAt(i)-sb.charAt(i+1)==-2){
                    sb.delete(i,i+2);
                    i = sb.length()-1;
                }else {
                    return false;
                }
            }
        }
        return sb.length()==0;
    }
}
