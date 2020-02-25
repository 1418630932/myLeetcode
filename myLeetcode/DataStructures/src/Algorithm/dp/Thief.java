package Algorithm.dp;

/**
 * @author zhuliyang
 * @date 2020-01-15
 * @time 23:59
 **/
public class Thief {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(max(arr));
    }

    //递归求解
    private static int max(int[] arr, int num) {
        if (num == 0) { //best
            return arr[0];
        } else if (num == 1) {//best between 0and1
            return Math.max(arr[0], arr[1]);
        } else {//best between arr[num]+max(num-2) and max(n-1)
            return Math.max(arr[num] + max(arr, num - 2), max(arr, num - 1));
        }
    }

    //非递归求解
    private static int max(int[] arr) {
        int[] best = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                best[0] = arr[0];
            } else if (i == 1) {
                best[1] = Math.max(arr[0], arr[1]);
            }else {
                best[i]=Math.max(arr[i]+best[i-2], best[i-1]);
            }
        }
        return best[arr.length-1];
    }
}
