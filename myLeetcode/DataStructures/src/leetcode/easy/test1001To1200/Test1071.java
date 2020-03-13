package leetcode.easy.test1001To1200;

/**
 * @author zhuliyang
 * @date 2020-03-12
 * @time 20:21
 **/
public class Test1071 {
    public static void main(String[] args) {
        String s = gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
                "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
        System.out.println(s);
    }
    public static String gcdOfStrings(String str1, String str2) {
        int min = str1.length()<str2.length()?str1.length():str2.length();
        String merge = str1 + str2;
        String res = "";
        for (int i = 1; i <= merge.length()&&i<=min; i++) {
            // 合并字符串  单个字符串   均可以被整除
            if (merge.length() % i == 0&&str1.length()%i==0&&str2.length()%i==0) {
                String common = merge.substring(0, i);
                boolean flag = true;
                for (int j = i; j <= merge.length()-i; j += i) {
                    if (!common.equals(merge.substring(j, j + i))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = common;
                }
            }
        }
        return res;
    }
}
