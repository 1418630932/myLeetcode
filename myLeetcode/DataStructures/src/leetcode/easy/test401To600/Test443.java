package leetcode.easy.test401To600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-02-15
 * @time 0:45
 **/
public class Test443 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','b','b','c','1','1','c'}));
    }
    public static int compress(char[] chars) {
        LinkedList<Character> list  =new LinkedList<>();
        int count =0;
        for (int i = 0; i <chars.length ; i++) {
            if (count!=0){
                if (list.getLast()==chars[i]){
                    count++;
                }else {
                    String str  = count==1?"": count+"";
                    for (int j = 0; j <str.length() ; j++) {
                        list.add(str.charAt(j));
                    }
                    list.add(chars[i]);
                    count=1;
                }
                if (i==chars.length-1){
                    String str  = count==1?"": count+"";
                    for (int j = 0; j <str.length() ; j++) {
                        list.add(str.charAt(j));
                    }
                }
            }else {
                list.add(chars[i]);
                count++;
            }
        }
        for (int i = 0; i <list.size() ; i++) {
            chars[i]=list.get(i);
        }
        return list.size();
    }
}
