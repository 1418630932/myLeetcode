package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-18
 * @time 13:37
 **/
public class Test46 {
    int res = 0;

    public int translateNum(int num) {
        String numStr = num + "";
        helper(numStr, 0);
        return res;
    }

    private void helper(String numStr, int index) {
        if (index == numStr.length()) {
            res++;
            return;
        }
        if (numStr.charAt(index) <= '9') {
            helper(numStr, index + 1);
        }
        if (index + 1 < numStr.length()) {
            int num = Integer.parseInt(numStr.substring(index, index + 2));
            if (num < 26) {
                helper(numStr, index + 2);
            }
        }
    }
}
