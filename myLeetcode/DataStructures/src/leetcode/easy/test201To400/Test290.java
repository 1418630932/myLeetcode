package leetcode.easy.test201To400;

import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-02-10
 * @time 16:35
 **/
public class Test290 {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> mapCtoS = new HashMap<>();
        HashMap<String, Character> mapStoC = new HashMap<>();
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            //映射关系不存在
            if (!mapCtoS.containsKey(pattern.charAt(i)) && !mapStoC.containsKey(strArr[i])) {
                mapCtoS.put(pattern.charAt(i), strArr[i]);
                mapStoC.put(strArr[i], pattern.charAt(i));
            } else {
                if (mapCtoS.get(pattern.charAt(i))!=null){
                    if (!mapCtoS.get(pattern.charAt(i)).equals(strArr[i]))return false;
                }
                if (mapStoC.get(strArr[i])!=null){
                    if (mapStoC.get(strArr[i])!=pattern.charAt(i))return false;
                }

            }
        }
        return true;
    }
}
