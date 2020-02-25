package Algorithm.kruskal;

import com.sun.javafx.geom.Edge;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-01-25
 * @time 22:00
 **/
public class Kruskal {
    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int[][] matrix =
                {{0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}};
        Kruskal kruskal = new Kruskal(vertexs,matrix);
        kruskal.kruskal();

    }
    private int edgeNum;//边的个数
    private char[] vertexs;//顶点个数
    private int[][] matrix;//邻接矩阵
    private static final  int INF = Integer.MAX_VALUE;
    public Kruskal(char[] vertexs,int[][] matrix){
        this.matrix = matrix;
        this.vertexs =vertexs;
        int count=0;
        //统计边
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = i+1; j <matrix[i].length ; j++) {
                if (matrix[i][j]!=INF){
                    count++;
                }
            }
        }
        this.edgeNum = count;
    }
    //对边从小到大排序
    public void sortEdgds(EData[] arr){
        Arrays.sort(arr);
    }
    //得到顶点的索引
    private int getPosition(char ch){
        for (int i = 0; i <vertexs.length ; i++) {
            if (ch==vertexs[i]){
                return i;
            }
        }
        return -1;
    }
    //得到边数组
    private EData[] getEdges(){
        EData[] arr = new EData[this.edgeNum];
        int index = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = i+1; j <matrix[i].length ; j++) {
                if (matrix[i][j]!=INF){
                    arr[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return arr;
    }
    //获取索引为i的顶点对应的终点的下标
    private int getEnd(int[] ends,int i){
        while (ends[i]!=0){
           i=ends[i];
        }
        return i;
    }

    public void kruskal(){
        int index=0;//外部指针
        int[] ends = new int[vertexs.length];//每个顶点的最终终点数组
        EData[] res = new EData[vertexs.length-1];
        EData[] edges = getEdges();
        sortEdgds(edges);//从小到大排序所有边
        for (int i = 0; i <edges.length ; i++) {
            int start = getPosition(edges[i].start);//起点的下标
            int end = getPosition(edges[i].end);//终点的下标
            int m = getEnd(ends, start);//起点的最终终点
            int n = getEnd(ends, end);///终点的最终终点
            if (m!=n){//如果不是一个最终终点 说明不能构成回路
                ends[m]=n;//更新最终终点
                res[index++]=edges[i];//记录最小生成树
            }
        }
        System.out.println(Arrays.toString(res));
    }

}
class EData implements Comparable<EData>{
    char start;
    char end;
    int weight;
    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(EData o) {
        return this.weight-o.weight;
    }
}