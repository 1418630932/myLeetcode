package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-28
 * @time 17:18
 **/
public class Test306 {
    public static void main(String[] args) {
        boolean additiveNumber = isAdditiveNumber("198019823962");
        System.out.println(additiveNumber);
    }

    public static boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length() - 2; i++) {
            if (i>0&&num.charAt(0)=='0')break;
            long num1 = Long.parseLong(num.substring(0, i + 1));
            for (int j = i + 1; j < num.length() - 1; j++) {
                if (j-i>1&&num.charAt(i+1)=='0')break;
                long num2 =  Long.parseLong(num.substring(i + 1, j + 1));
                boolean res = helper(num, num1, num2, j + 1);
                if (res) return true;
            }
        }
        return false;
    }

    private static boolean helper(String num, long num1, long num2, int index) {
        if (index == num.length()) {
            return true;
        }
        if (num.charAt(index) == '0'&&num2!=0) return false;
        boolean res = false;
        for (int i = index; i < num.length(); i++) {
            long numAfter =  Long.parseLong(num.substring(index, i + 1));
            if (num1 + num2 == numAfter) {
                res |= helper(num, num2, numAfter, i + 1);
            }
        }
        return res;
    }
}
