package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-03-09
 * @time 20:29
 **/
public class Test165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i=0;
        int j= 0;
        while (i<arr1.length&&j<arr2.length){
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[j]);
            if (v1>v2)return 1;
            if (v1<v2)return -1;
            i++;
            j++;
            if (i==arr1.length){
                while (j<arr2.length&&Integer.parseInt(arr2[j])==0){
                    j++;
                }
                return j==arr2.length?0:-1;
            }
            if (j==arr2.length){
                while (i<arr1.length&&Integer.parseInt(arr1[i])==0){
                    i++;
                }
                return i==arr1.length?0:1;
            }
        }
        return 0;
    }
}
