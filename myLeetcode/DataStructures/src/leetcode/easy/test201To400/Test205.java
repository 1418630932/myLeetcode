package leetcode.easy.test201To400;

import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-02-08
 * @time 15:40
 **/
public class Test205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic1("aa","at" ));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sTOt = new HashMap<>();//s-->t
        HashMap<Character,Character> tTOs = new HashMap<>();//t-->s
        for (int i = 0; i <s.length() ; i++) {
            if (!sTOt.containsKey(s.charAt(i))&&!tTOs.containsKey(t.charAt(i))){
                sTOt.put(s.charAt(i),t.charAt(i) );
                tTOs.put(t.charAt(i),s.charAt(i) );
            }else {
                //s已经映射过或者t已经映射过
                if (sTOt.get(s.charAt(i))!=null){
                    if (t.charAt(i)!=sTOt.get(s.charAt(i)))return false;
                }else if (tTOs.get(t.charAt(i))!=null){
                    if (s.charAt(i)!=tTOs.get(t.charAt(i)))return false;
                }
            }
        }
        return true;
    }

    public static boolean isIsomorphic1(String s, String t) {
        int[] arrs = new int[256];
        int[] arrt = new int[256];
        for (int i = 0; i <s.length() ; i++) {
            if (arrs[s.charAt(i)]!=arrt[t.charAt(i)])return false;//对应的索引位置不同
            arrs[s.charAt(i)]=i+1;
            arrt[t.charAt(i)]=i+1;
        }
        return true;
    }
}
