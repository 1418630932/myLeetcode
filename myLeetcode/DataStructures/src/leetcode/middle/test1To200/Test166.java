package leetcode.middle.test1To200;

import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-03-10
 * @time 19:23
 **/
public class Test166 {
    public static void main(String[] args) {
        System.out.print(fractionToDecimal1(1,13 ));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        res.append(numerator / denominator);
        int tail =  numerator%denominator;
        if (tail!=0){
            res.append(".");
        }

        int loopStart = tail;
        while (tail!=0){
            res.append(10*tail/denominator);
            tail=tail*10%denominator;
            if (tail==loopStart){
                String prefix = res.substring(0, res.indexOf(".")+1);
                String inner = res.substring(res.indexOf(".")+1,res.length());
                return prefix+"("+inner+")";
            }
        }
        return res.toString();
    }


    public static String fractionToDecimal1(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        res.append(numerator / denominator);
        int tail =  numerator%denominator;
        if (tail!=0){
            res.append(".");
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =res.length()-1;
        while (tail!=0){
            count++;
            int num = 10*tail;
            if (num!=0&&!map.containsKey(num)){
                map.put(num,count );
            }else if (num!=0){//出现重复
                String prefix = res.substring(0,map.get(num));
                String inner = res.substring(map.get(num),res.length());
                return prefix+"("+inner+")";
            }
            res.append(10*tail/denominator);
            tail=tail*10%denominator;
        }
        return res.toString();
    }


}
