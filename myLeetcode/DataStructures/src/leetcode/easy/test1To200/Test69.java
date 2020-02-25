package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-02
 * @time 15:09
 **/
public class Test69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
    //牛顿切线逼近法
    // f(x) = x^2-a   任意一点x的导数为 2x
    // 任意一点x的切线   g(x) = 2x*x+a  得到与x轴的切点x1
    // 根据g（x）导数 =2x 得到：(f(x)-0)/(x-x1)=2x==>x^2-a = 2x^2-2xx1===>  x1 = (x+a/x)/2
    public static int mySqrt(int a) {
        long x =a ;
        while (x>a/x){
            x = (x+a/x)/2;
        }
        return (int) x;
    }
}
