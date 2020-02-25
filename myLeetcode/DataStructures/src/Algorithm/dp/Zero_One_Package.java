package Algorithm.dp;

import java.util.ArrayList;

//01背包
public class Zero_One_Package {
    public static void main(String[] args) {
        ArrayList<AnyThing> arrayList = new ArrayList();
        AnyThing guitar = new AnyThing(1500,1 );
        AnyThing radio = new AnyThing(3000,4 );
        AnyThing tv = new AnyThing(2000,3);
        arrayList.add(guitar);
        arrayList.add(radio);
        arrayList.add(tv);
        System.out.println(max(arrayList,4 ));
        System.out.println(best(4,3 ,arrayList ));
    }

    /**
     * 01背包问题
     * @param arrayList 商品列表
     * @param limit   背包容量
     * @return
     */
    public static int max(ArrayList<AnyThing> arrayList ,int limit){
        //x轴代表背包容量 y轴代表每种商品
        // arr[x][y] 代表背包容量为x的时候  第y种商品放入或者不放入时的最大利益
        int[][] arr = new int[arrayList.size()+1][limit+1];
        for (int i = 0; i < limit+1; i++) {//背包内0件商品的时候 价值都是0
            arr[0][i]=0;
        }
        for (int i = 0; i < arrayList.size() + 1; i++) {//背包容量为0的时候 价值都是0
            arr[i][0]=0;
        }
        for (int i = 1; i <arr.length ; i++) {//第几个商品
            for (int j = 1; j <arr[i].length ; j++) {//背包容量
                int weight = arrayList.get(i-1).weight;//当前商品重量
                if (weight>j){//当前物品重量超过背包容量j 就不放 当前最大值=不放这个物品的最大值
                    arr[i][j]=arr[i-1][j];

                }else {
                    //不放 最大值=当前空间 另外几种商品放入背包的最大价值
                    //放   最大值=当前商品价值+背包剩余空间的最大放入价值
                    arr[i][j]=Math.max(arr[i-1][j], arrayList.get(i-1).value+arr[i-1][j-weight]); //max(不放，放)
                }
            }
        }
        return arr[arrayList.size()][limit];
    }
    public static int best(int limit,int numOfThings,ArrayList<AnyThing> list){
        if (numOfThings==0){
            return 0;
        }
        int weight = list.get(numOfThings-1).weight;
        if (weight>limit){
            return best(limit,numOfThings-1 ,list );
        }
        int value = list.get(numOfThings-1).value;
        //放与不放
        return Math.max(best(limit,numOfThings-1 ,list ),value+best(limit-weight, numOfThings-1, list) );
    }
}

class AnyThing{
    int value;
    int weight;

    public AnyThing(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
