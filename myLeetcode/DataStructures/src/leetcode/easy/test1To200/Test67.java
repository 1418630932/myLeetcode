package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-02
 * @time 14:16
 **/
public class Test67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011" ));
    }
    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int sum =0;
        int ca=0;
        int i = a.length()-1;
        int j = b.length()-1;
        while (i>=0||j>=0){
            sum += i>=0?a.charAt(i)-'0':0;
            sum += j>=0?b.charAt(j)-'0':0;
            sum+=ca;
            ca = sum/2;
            sb.append(sum%2);
            i--;
            j--;
            sum=0;
        }
        if (ca!=0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
