package leetcode.easy.test401To600;

import com.sun.deploy.util.StringUtils;

/**
 * @author zhuliyang
 * @date 2020-02-13
 * @time 16:49
 **/
public class Test434 {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello,    my                 name         is  John"));
    }
    public  static int countSegments(String s) {
        if (s==null||s.length()==0) return 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i <s.length() ; i++) {
            if (isSegments(s.charAt(i))){
                if (!flag){
                    count++;
                }
                flag=true;
            }else {
                flag = false;
            }
        }
        return count;
    }
    public  static boolean isSegments(char c){
        return c>='a'&&c<='z'||c>='A'&&c<='Z';
    }
}
