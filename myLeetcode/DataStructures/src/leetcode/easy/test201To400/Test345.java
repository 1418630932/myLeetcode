package leetcode.easy.test201To400;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-02-11
 * @time 20:09
 **/
public class Test345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int left = 0;
        int right = s.length();
        char[] chars = s.toCharArray();
        while (left<right){
            while (!set.contains(chars[left])){
                left++;
            }
            while (!set.contains(chars[right])){
                right--;
            }
            char temp = chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
        }
        return new String(chars);


    }
}
