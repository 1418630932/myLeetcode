package leetcode.middle.test1201To1400;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-04-21
 * @time 12:07
 **/
public class Test1248 {
    public static void main(String[] args) {
        int i = numberOfSubarrays2(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
        System.out.println(i);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int index = 1;
        int[] odd = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odd[index++] = i;
            }
        }
        odd[0] = -1;
        odd[index] = nums.length;
        if (index < k) return 0;
        int res = 0;
        for (int i = 1; i < index; i++) {
            if (i + k <= index) {
                res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
            }
        }
        return res;
    }

    public static int numberOfSubarrays2(int[] nums, int k) {
        int res = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int index = 0;
        for (int num : nums) {
            if (num % 2 == 1) index++;
            if (index >= k) res += count[index - k];
            count[index]++;
        }
        return res;
    }

}

// 加写锁, 防止其它线程对缓存读取和更改