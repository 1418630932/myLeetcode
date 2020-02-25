package Algorithm.search;

/**
 * 插值查找算法
 *
 * @author zhuliyang
 * @date 2019-12-25
 * @time 22:51
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(insertSearch(arr, 0, arr.length - 1, 5));
    }

    public static int insertSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;//递归出口
        }
        //求出索引
        int index = left + ( right-left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (arr[index] > findVal) {
            insertSearch(arr, left, index - 1, findVal);
        } else if (arr[index] < findVal) {
            insertSearch(arr, index + 1, right, findVal);
        }
        return index;


    }
}
