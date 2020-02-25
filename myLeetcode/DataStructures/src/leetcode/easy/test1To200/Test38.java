package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-01
 * @time 15:30
 **/
public class Test38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if (n==1){
            return "1";
        }
        String s = countAndSay(n - 1);
        int index =0;//第二指针
        StringBuffer res = new StringBuffer();
        int count =0;//记录字符出现次数
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(index)==s.charAt(i)){
                count++;
            }else {
                res.append(count).append(s.charAt(index));
                index=i;
                count=1;
            }
            if (i==s.length()-1){
                res.append(count).append(s.charAt(index));
            }
        }
        return res.toString();
    }
}
