package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-10
 * @time 15:36
 **/
public class Test278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version) {
        return version >= 4;
    }
}
