package Algorithm.sort;

import leetcode.utils.TreeNode;

import java.util.Arrays;

/**
 * 堆排序
 * @author zhuliyang
 * @date 2019-12-30
 * @time 22:56
 **/
public class HeapSort {
//    public static void main(String[] args) {
//        int[] arr = {55,-55,7,4,2,1,33};
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
    public static void heapSort(int[] arr){
        //第一次从下往上构建一个完整的大顶堆
        for (int i = arr.length/2-1; i >=0;  i--) {
            adjustHeap(arr,i ,arr.length );
        }
        for (int i = arr.length-1; i >0 ; i--) {
            //堆顶元素和末尾元素交换 （最大的元素放在数组最后）
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            //再次构建大顶堆
            // 由于上面的for循环已经从下往上使大顶堆构建完成
            //再次构建从arr[0]从上向下构建 也可以保证大顶堆的合法性 效率由adjsutHeap中的else{break}来保证
            adjustHeap(arr,0 ,i );
        }
    }
    public static void adjustHeap(int[] arr , int i,int length){
        int temp = arr[i];
        for (int k = 2*i+1; k <length ; k=2*k+1) {//从定义的i节点的左子节点开始
            if (k+1<length&&arr[k]<arr[k+1]){
                k++;//左右两个节点 取大的节点
            }
            if (arr[k]>temp){//如果大的节点比父节点数据大
                arr[i]=arr[k];//大的值覆盖
                i=k;//走进大的节点
            }else {
                break;//从上向下构建的时候，保证效率
            }
        }
        arr[i]=temp;
    }

    public static void main(String[] args) {
        System.out.println(add("123456789","987654321"));
    }

    public static String add(String s1 ,String s2){
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        String  res =  "";
        int add = 0;
        int i = charArr1.length-1;
        int j = charArr2.length-1;
        while(i>=0||j>=0||add>0){
            int sum = 0;
            if(i>=0){
                sum += charArr1[i--]-'0';
            }
            if(j>=0){
                sum += charArr2[j--]-'0';
            }
            if(add>0){
                sum += add;
            }
            res  = sum%10 +res;
            add = sum/10;
        }
        return res;
    }



    public int rob(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        dp2[nums.length-1] = nums[nums.length-1];
        dp2[nums.length-2] = Math.max(nums[nums.length-1],nums[nums.length-2]);
        for(int i=2;i<nums.length-1;i++){
            dp1[i] = Math.max(nums[i]+dp1[i-2],dp1[i-1]);
        }
        for(int i=nums.length-3;i>=0;i--){
            dp2[i] = Math.max(nums[i]+dp2[i+2],dp2[i+1]);
        }
        return Math.max(dp1[dp1.length-2],dp2[1]);
    }

}
