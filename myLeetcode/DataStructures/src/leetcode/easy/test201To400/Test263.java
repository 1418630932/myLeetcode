package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-10
 * @time 15:20
 **/
public class Test263 {
    public boolean isUgly(int num) {
        while (num != 0 && (num % 2 == 0 || num % 3 == 0 || num % 5 == 0)) {
            if (num % 2 == 0)
                num /= 2;
            if (num % 3 == 0)
                num /= 3;
            if (num % 5 == 0)
                num /= 5;
        }
        return num == 1;
    }
}
