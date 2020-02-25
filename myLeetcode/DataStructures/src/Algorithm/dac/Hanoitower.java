package Algorithm.dac;

/**
 * @author zhuliyang
 * @date 2020-01-14
 * @time 23:33
 **/
public class Hanoitower {
    public static void main(String[] args) {
        move(5,'a' ,'b' ,'c' );
    }
    //把汉诺塔简化成两块  x：最底下的一块 ；y：上面的一堆看成一块
    //移动过程转换成三步  y从a移动到b；x从a移动到c；y从b移动到c
    public static void move(int num,char a,char b,char c){
        if (num==1){//如果只有一块 直接移动
            System.out.println(a+"-->"+c);
        }else {
            move(num-1, a, c, b);//y从a移动到b
            System.out.println(a+"-->"+c);//x从a移动到c
            move(num-1,b ,a ,c );//y从b移动到c
        }
    }
}
