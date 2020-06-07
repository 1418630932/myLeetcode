package leetcode.middle.test201To400;

import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-05-28
 * @time 0:11
 **/
public class Test394 {
    public static void main(String[] args) {
        String string = decodeString("2[abc3[cd]]ef");
        System.out.println(string);
    }
    public static String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> bucketStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if (isBrackets(c)){
                if (c=='['){
                    bucketStack.push(c);
                }else {
                    if (temp.length()!=0){
                        strStack.push(temp.toString());
                    }
                    bucketStack.pop();
                    int pop = numberStack.pop();
                    String strPop = strStack.pop();
                    StringBuffer sb = new StringBuffer();
                    for (int j = 0; j <pop ; j++) {
                        sb.append(strPop);
                    }
                    if (strStack.isEmpty()){
                        strStack.push(sb.toString());
                    }else {
                        String pop1 = strStack.pop();
                        strStack.push(pop1+sb);
                    }
                    temp.setLength(0);
                }
            }else if (isNumber(c)){
                numberStack.push(c-'0');
                if (temp.length()!=0){
                    strStack.push(temp.toString());
                }
                temp.setLength(0);
            }else {
                temp.append(c);
            }
        }
        String res ="";
        for (String s1 : strStack) {
            res += s1;
        }
        return res+temp;
    }
    public static boolean isNumber(char c){
        return '0'<= c && c<='9';
    }
    public static boolean isBrackets(char c){
        return '['==c || ']'==c;
    }

}
