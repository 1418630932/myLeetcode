package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-23
 * @time 16:10
 **/
public class Test60 {
    public static void main(String[] args) {
        String res = getPermutation(3,3 );
        System.out.println(res);
    }
    public static String getPermutation(int n, int k) {
        int part = 1 ;
        for (int i = 1; i <n ; i++) {
            part*=i;
        }
        int startNum = (k-1)/part+1;
        int remain = k%part==0?part:k%part;
        boolean[] isVisited = new boolean[n+1];
        isVisited[startNum]=true;
        StringBuilder  res =new StringBuilder(startNum+"");
        helper(isVisited,remain,0,res);
        return res.toString();
    }

    private static int helper(boolean[] isVisited, int remain, int count,StringBuilder res) {

        if (res.length()==isVisited.length-1){
            return ++count;
        }
        for (int i = 1; i <isVisited.length ; i++) {
            if (!isVisited[i]){//剪枝
                isVisited[i]=true;
                res.append(i);
                count=helper(isVisited,remain ,count ,res);
                if (count==remain){
                    break;
                }
                res.deleteCharAt(res.length()-1);//回溯
                isVisited[i]=false; //回溯
            }
        }
        return count;
    }

}
