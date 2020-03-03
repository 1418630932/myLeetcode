package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-03-03
 * @time 15:14
 **/
public class Test134 {
    public static void main(String[] args) {
        int i = canCompleteCircuit1(new int[]{2,3,4}, new int[]{3, 4, 3});
        System.out.println(i);
    }
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int total_tank  = 0 ;
        int cur_tank =0;
        int start_Station = 0;
        for (int i = 0; i <gas.length ; i++) {
            total_tank +=gas[i]-cost[i];
            cur_tank +=gas[i]-cost[i];
            if (cur_tank<0){
                cur_tank=0;
                start_Station = i+1;
            }
        }
        return total_tank>=0?start_Station:-1;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i <diff.length ; i++) {
            diff[i] = gas[i] -cost[i];
        }
        for (int i = 0; i <diff.length ; i++) {
            if (diff[i]>=0){
                if (canArrived(diff,i))return i;
            }
        }
        return -1;
    }

    private static boolean canArrived(int[] diff, int i) {
        int sum = 0;
        for (int num : diff) {
            sum += diff[i++ % diff.length];
            if (sum < 0) return false;
        }
        return true ;
    }
}
