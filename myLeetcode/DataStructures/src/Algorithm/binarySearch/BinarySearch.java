package Algorithm.binarySearch;

/**
 * @author zhuliyang
 * @date 2020-01-14
 * @time 22:44
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1,4,6,8,9,12,15};
        int i = binarySearch(arr, 16);
        System.out.println(i);
    }
    public static int binarySearch(int[] arr,int target){
        int mid = arr.length/2;
        int left =0;
        int right=arr.length-1;
        while (left<=right){
            mid=(left+right)/2;
            if (arr[mid]>target){
                right=mid-1;
            }else if (arr[mid]<target){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
