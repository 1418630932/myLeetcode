package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-25
 * @time 20:35
 **/
public class Test275 {
    public static void main(String[] args) {
        int i = hIndex(new int[]{0, 1, 3, 5, 6});
        System.out.println(i);
    }
    public static int hIndex(int[] citations) {
        if(citations.length==0)return 0;
        if(citations[citations.length-1]==0)return 0;
        int left = 0;
        int right = citations.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            int h = citations.length-mid;
            if (h<=citations[mid]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return citations.length-right;
    }
}
