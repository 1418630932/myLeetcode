package leetcode.easy.test401To600;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-15
 * @time 17:29
 **/
public class Test455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count =0;
        int i =0;
        int j =0;
        while(i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}
