package leetcode.middle.test1001To1200;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;

/**
 * @author zhuliyang
 * @date 2020-06-17
 * @time 23:35
 **/
public class Test1014 {
    public int maxScoreSightseeingPair(int[] arr) {
        int left = arr[0];
        int res =Integer.MIN_VALUE;
        for(int i = 1 ;i<arr.length;i++){
            res = Math.max(res,left +arr[i]-i );
            left = Math.max( left,arr[i]+i);
        }
        return res ;
    }
}
