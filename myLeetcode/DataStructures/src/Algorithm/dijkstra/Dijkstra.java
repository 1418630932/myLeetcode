package Algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-01-27
 * @time 23:05
 **/
public class Dijkstra {
    public static void main(String[] args) {
        final int N = 65535;
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        Graph graph = new Graph(vertexs, matrix);
        graph.djs(3);
    }

}

class Graph {
    private char[] vertexs;//顶点个数
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;//顶点关系类

    public Graph(char[] vertexs, int[][] matrix) {
        this.matrix = matrix;
        this.vertexs = vertexs;
    }

    public void show() {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 迪杰斯特拉算法
     *
     * @param index 出发节点的索引
     */
    public void djs(int index) {
        this.vv = new VisitedVertex(vertexs.length, index);
        update(index);//第一个节点作为起点
        //遍历其他节点
        for (int i = 1; i <vertexs.length ; i++) {
            int next = vv.getNext();
            update(next);
        }
        System.out.println(Arrays.toString(vv.dis));
    }

    public void update(int index) {
        int len =0;
        for (int i = 0; i < matrix[index].length; i++) {
            len = vv.getDis(index) + matrix[index][i];//累加距离（到这个点的距离+本次的距离）
            if (!vv.isVisited(i) && len < vv.getDis(i)) {//结点没访问过 并且距离小于历史距离
                vv.updateDis(i, len);
            }
        }
    }
}

class VisitedVertex {
    public int[] already_arr;//记录各个顶点是否访问过的数组
    public int[] dis;         //记录出发顶点到每个顶点的距离，最终要返回的结果

    public VisitedVertex(int length, int index) {
        already_arr = new int[length];
        already_arr[index] = 1;//设置出发顶点被访问过
        dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis, 65535);
        dis[index] = 0;//设置出发点的距离=0
    }

    public boolean isVisited(int index) {
        return already_arr[index] == 1;
    }

    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    public int getDis(int index) {
        return dis[index];
    }
    //获取距离最短的未访问的节点的下标
    public int getNext(){
        int min = 65535;
        int index =0;
        for (int i = 0; i <already_arr.length ; i++) {
            if (already_arr[i]==0&&dis[i]<min){
                min=dis[i];
                index=i;
            }
        }
        already_arr[index]=1;//设置为访问过
        return index;
    }
}