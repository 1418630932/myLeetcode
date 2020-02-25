package leetcode.easy.test401To600;

/**
 * @author zhuliyang
 * @date 2020-02-13
 * @time 14:30
 **/
public class Test405 {
    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }
    public static String toHex(int num) {
        String[] table = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        StringBuffer sb = new StringBuffer();
        while (num!=0){
            String tail = table[num&15];
            sb.append(tail);
            num = num>>>4;
        }
        return sb.reverse().toString();
    }
}
