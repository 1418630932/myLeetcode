package leetcode.hard;

/**
 * @author zhuliyang
 * @date 2020-04-19
 * @time 14:08
 **/
public class Test466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int index1 =0; int index2 = 0;int s2Count = 0;
        int res =0;
        while (n1>0){
            if (chars1[index1++]==chars2[index2]){
                index2++;
            }
            if (index1==chars1.length){
                index1=0;
                n1--;
            }
            if (index2==chars2.length){
                index2=0;
                s2Count++;
            }
            if (s2Count==n2){
                res++;
                s2Count=0;
            }
        }
        return res;
    }
}
