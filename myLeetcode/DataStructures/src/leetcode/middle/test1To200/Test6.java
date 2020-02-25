package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-18
 * @time 16:38
 **/
public class Test6 {
    public static void main(String[] args) {
        convert("LEETCODEISHIRING",3 );
    }
    public static String convert(String s, int numRows) {
        if(numRows<=1) return s;
        String[] res = new String[numRows];
        Arrays.fill(res,"" );
        for (int i = 0; i <s.length() ; i++) {
            int index =0;
            if(i%(numRows*2-2)<numRows){
                index = i%(numRows*2-2);
            }else {
                index = numRows*2-2-i%(numRows*2-2);
            }
            res[index] = res[index]+s.charAt(i);
        }
        StringBuffer sb = new StringBuffer();
        for (String re : res) {
            sb.append(re);
        }
        return sb.toString();
     }
}
