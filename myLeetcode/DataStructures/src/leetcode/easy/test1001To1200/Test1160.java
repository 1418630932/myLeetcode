package leetcode.easy.test1001To1200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-03-17
 * @time 17:45
 **/
public class Test1160 {
    public static void main(String[] args) {
        int aatach = countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "aatach");
        System.out.println(aatach);
    }

    public static int countCharacters(String[] words, String chars) {
        int[] source = new int[26];
        int[] temp = null;
        for (int i = 0; i < chars.length(); i++) {
            source[chars.charAt(i) - 97]++;
        }
        int length = 0;
        for (String str : words) {
            boolean flag = true;
            temp = Arrays.copyOf(source, source.length);
            for (int i = 0; i < str.length(); i++) {
                if (--temp[str.charAt(i) - 97] < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                length += str.length();
            }
        }
        return length;
    }
}
