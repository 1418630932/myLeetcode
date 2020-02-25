package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-02-24
 * @time 14:22
 **/
public class Test71 {
    public static void main(String[] args) {

//        String[] split = "/a//b////c/d//././/..".split("/");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i].length());
//        }
//        System.out.println(Arrays.toString(split));
        System.out.println(simplifyPath("/../"));
    }
    public static String simplifyPath(String path) {
        if (path==null)return "/";
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (int i = 0; i <split.length ; i++) {
            if (split[i].equals("")||split[i].equals(".")){
                continue;
            }else {
                if (split[i].equals("..")){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                }else {
                    stack.push(split[i]);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0, "/" + stack.pop());
        }
        return res.length()==0?"/":res.toString();
    }
}
