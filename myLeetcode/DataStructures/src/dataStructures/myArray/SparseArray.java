package dataStructures.myArray;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2019-11-30
 * @time 23:38
 **/
public class SparseArray {
    public static void main(String[] args) {
        //1将原数组压缩成稀疏数组
        int[][] arrs = new int[11][11];
        arrs[1][2] =1;//黑子
        arrs[2][3] =2;//蓝子
        int count=0;
        //得到非0数据个数
        for (int[] arr : arrs) {
            for (int i : arr) {
                if (i!=0){
                    count++;
                }
            }
        }
        int[][] sparseArr = new int[count+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=count;
        int t =1;
        for (int i = 0; i <arrs.length ; i++) {
            for (int j = 0; j <arrs[i].length ; j++) {
                if (arrs[i][j]!=0){
                    sparseArr[t][0]=i;
                    sparseArr[t][1]=j;
                    sparseArr[t][2]=arrs[i][j];
                    t++;
                }
            }
        }
        //打印验证
        for (int[] ints : sparseArr) {
            System.out.println(Arrays.toString(ints));
        }

        //2将稀疏数组恢复成原数组
        int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <sparseArr.length ; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //打印验证
        for (int[] ints : arr2) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
