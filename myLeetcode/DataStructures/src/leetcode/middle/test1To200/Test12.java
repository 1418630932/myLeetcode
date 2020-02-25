package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-18
 * @time 20:54
 **/
public class Test12 {
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i <14 ; i++) {
            while (num>number[i]){
                num -= number[i];
                res.append(str[i]);
            }
        }
        return res.toString();
    }
}
