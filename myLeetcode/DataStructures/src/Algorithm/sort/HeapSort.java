package Algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author zhuliyang
 * @date 2019-12-30
 * @time 22:56
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {55,-55,7,4,2,1,33};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
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
}
