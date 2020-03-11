package leetcode.easy.test1001To1200;

/**
 * @author zhuliyang
 * @date 2020-03-11
 * @time 18:32
 **/
public class Test1013 {
    public static void main(String[] args) {
        boolean b = canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, -1, 2, 0, 1});
        System.out.println(b);
    }
    public static boolean canThreePartsEqualSum(int[] A) {
        int[] sumArr = new int[A.length];
        sumArr[0] = A[0];
        for(int i=1;i<sumArr.length;i++){
            sumArr[i] = sumArr[i-1]+A[i];
        }
        for(int i=0;i<sumArr.length-2;i++){
            if (sumArr[sumArr.length-1]==3*sumArr[i]){
                for(int j=i+1;j<sumArr.length-1;j++){
                    if (sumArr[j]==2*sumArr[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
