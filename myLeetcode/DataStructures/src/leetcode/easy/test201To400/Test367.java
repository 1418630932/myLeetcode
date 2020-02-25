package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 14:39
 **/
public class Test367 {
    public static void main(String[] args) {
        boolean perfectSquare = isPerfectSquare(5);
        System.out.println(perfectSquare);
        System.out.println(200000*200000);
    }
    public static boolean isPerfectSquare(int num) {
        if(num==0||num==1||num==4)return true;
        if(num<4)return false;
        int left =0;
        int right = num >>>1;
        while(left<=right){
            int mid= (left+right)>>>1;
            if(mid<num/mid){
                left=mid+1;
            }else if(mid>num/mid){
                right=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
