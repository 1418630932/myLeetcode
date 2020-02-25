package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-11
 * @time 20:07
 **/
public class Test344 {
    public void reverseString(char[] s) {
        int left =0;
        int right = s.length-1;
        while(left<right){
            char temp = s[right];
            s[right--]=s[left];
            s[left++]=temp;
        }
    }
}
