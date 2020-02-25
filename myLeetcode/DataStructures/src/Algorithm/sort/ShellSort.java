package Algorithm.sort;

import java.util.Random;

/**
 * @author zhuliyang
 * @date 2019-12-17
 * @time 22:49
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10000);
        }
        Long timeBefore = System.currentTimeMillis();
        shellSort(arr);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("总共耗时：" + (timeAfter - timeBefore) / 1000 + "秒");//3秒
//        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];//插入的值
                int insertIndex = i - gap;//插入的索引
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {//如果插入的数要比比较的数小
                    arr[insertIndex + gap] = arr[insertIndex];//比较的数向后移动gap位
                    insertIndex-=gap;//插入的索引向前移动gap位
                }
                //走出循环表示找到了插入的索引前一位
                arr[insertIndex + gap] = insertValue;//进行插入（值的覆盖）
            }
        }

    }
}
