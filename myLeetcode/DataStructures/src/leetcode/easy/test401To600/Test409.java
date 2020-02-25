package leetcode.easy.test401To600;

/**
 * @author zhuliyang
 * @date 2020-02-13
 * @time 15:10
 **/
public class Test409 {
    public int longestPalindrome(String s) {
        int[] charArray = new int[256];
        for(int i = 0 ;i<s.length();i++){
            charArray[s.charAt(i)]++;
        }
        int count = 0 ;
        boolean flag =false;
        for(int num : charArray){
            if((num&1)==0){
                count +=num;
            }else{
                flag=true;
                count +=num-1;
            }
        }
        return flag?count+1:count;
    }
}
