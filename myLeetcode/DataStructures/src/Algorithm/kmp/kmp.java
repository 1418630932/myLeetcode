package Algorithm.kmp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-01-17
 * @time 21:16
 **/
public class kmp {
    public static void main(String[] args) {
        String s1 = "ewq rq erdd fdd sf  wewq  dsadad";
        String s2 = "dd ";
        System.out.println(kmpSearch(s1, s2,prefixTable(s2) ));
    }

    public static int kmp(String s1, String s2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s1.length() - s2.length(); i++) {
            String key = s1.substring(i, i+s2.length());
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, i);
            }
        }
        return hashMap.get(s2) == null ? -1 : hashMap.get(s2);
    }
    public static int[] prefixTable(String str){
        int[] prefixTable= new int[str.length()];
        prefixTable[0]=0;//长度为1的前缀最长公共前缀=0
        for (int i = 1,j=0; i <str.length() ; i++) {
            while (j>0&&str.charAt(i)!=str.charAt(j)){
                //回溯到上一个最长公共前后缀，再次进行匹配
                //可以理解为 当前最长公共前后缀不匹配，我们求第二长公共前后缀（即当前前后缀的最长公共前后缀）
                j=prefixTable[j-1];
            }
            if (str.charAt(i)==str.charAt(j)){
               j++;//长度为i的前缀最长公共前后缀=j
            }
            prefixTable[i]=j;
        }
        return prefixTable;
    }

    public static int kmpSearch(String s1, String s2,int[] prefixTable){
        for (int i = 0,j=0; i <s1.length() ; i++) {
            while (j>0&&s1.charAt(i)!=s2.charAt(j)){
                //回溯到上一个最长公共前后缀，再次进行匹配
                //可以理解为 当前最长公共前后缀不匹配，我们求第二长公共前后缀（即当前前后缀的最长公共前后缀）
                j=prefixTable[j-1];
            }
            if (s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            if (j==s2.length()){//找到了
                return i-j+1;//返回索引
            }
        }
        return -1;
    }
}
