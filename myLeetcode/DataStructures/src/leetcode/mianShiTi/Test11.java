package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-03
 * @time 12:00
 **/
public class Test11 {
    public static void main(String[] args) {
        int i = minArray(new int[]{3, 3,3,1,3,3,3,3,3,3,3,3});
        System.out.println(i);
    }

    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else {
                if (numbers[mid + 1] < numbers[mid]) {
                    mid = mid + 1;
                }else if (numbers[mid+1]==numbers[mid]){
                    left = mid+1;
                    continue;
                }
                right = mid;
            }
        }
        return numbers[right];
    }
}
