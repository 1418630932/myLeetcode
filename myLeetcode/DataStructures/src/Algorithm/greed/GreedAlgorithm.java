package Algorithm.greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**贪心算法
 * @author zhuliyang
 * @date 2020-01-20
 * @time 21:51
 **/
public class GreedAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadCast = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadCast.put("K1",hashSet1 );
        broadCast.put("K2",hashSet2 );
        broadCast.put("K3",hashSet3 );
        broadCast.put("K4",hashSet4 );
        broadCast.put("K5",hashSet5 );

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("广州");
        allAreas.add("深圳");

        ArrayList<String> selects = new ArrayList<>();//符合条件的结果集
        HashSet<String> tempSet = new HashSet<>();
        String maxKey=null;//最大电台指向
        while (allAreas.size()!=0){//还有没覆盖的电台
            maxKey=null;//初始化指向
            for (String s : broadCast.keySet()) {//遍历电台
                tempSet.clear();//初始化
                HashSet<String> areas = broadCast.get(s);//得到电台
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);//求出交集 并且赋值给tempSet
                //如果覆盖范围比当前最大覆盖范围还大，最大电台就是本次得到的电台
                if (tempSet.size()>0&&(maxKey==null||tempSet.size()>broadCast.get(maxKey).size())){
                    maxKey=s;
                }
            }
            allAreas.removeAll(broadCast.get(maxKey));//去除最大电台覆盖的地区
            selects.add(maxKey);//记录下最大覆盖电台
        }
        System.out.println(selects);
    }
}
