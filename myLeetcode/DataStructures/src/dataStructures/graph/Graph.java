package dataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhuliyang
 * @date 2020-01-12
 * @time 16:26
 **/
public class Graph {
    public static void main(String[] args) throws InterruptedException {
        String[] vertexs = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(vertexs.length);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        graph.insertEdges(0,1 ,1 );
        graph.insertEdges(0,2 ,1 );
        graph.insertEdges(1,3 ,1 );
        graph.insertEdges(1,4 ,1 );
        graph.insertEdges(3,7 ,1 );
        graph.insertEdges(4,7 ,1 );
        graph.insertEdges(2,5 ,1 );
        graph.insertEdges(2,6 ,1 );
        graph.insertEdges(5,6 ,1 );
        graph.showGraph();
      // dataStructures.graph.dfs();
       graph.bfs();
    }

    private ArrayList<String> vertexList;//顶点list
    private int[][] edges;//邻接矩阵
    private int numOfEdges;//表示边的个数
    private boolean[] isVisited;//是否被访问的数组
    private ArrayBlockingQueue<Integer> vertexQueue;//广度优先遍历的队列
    //构造方法 n表示顶点数
    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.numOfEdges = 0;
        this.isVisited = new boolean[n];
        this.vertexQueue= new ArrayBlockingQueue<>(n);
    }

    //添加顶点
    public void insertVertex(String string) {
        vertexList.add(string);
    }

    /**
     * 添加边
     *
     * @param v1     起始顶点
     * @param v2     结束顶点
     * @param weight 路径权值
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回顶点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回对应下标顶点的值
    public String getVertex(int index) {
        return vertexList.get(index);
    }

    //获取两顶点之间的权值
    public int getWeightOfV1AndV2(int v1, int v2) {
        return edges[v1][v2];
    }

    //得到第一个邻接节点的索引
    public int getFristNeighbour(int index){
        for (int i = index; i <vertexList.size() ; i++) {
            if (edges[index][i]==1){
                return i;
            }
        }
        return -1;
    }

    //得到当前节点的下一个邻接节点索引
    public int getNextNeighbour(int v1,int v2){
        for (int i = v2+1; i <vertexList.size() ; i++) {
            if (edges[v1][i]==1){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    public void dfs(int start){
        System.out.println(getVertex(start));//打印当前顶点
        isVisited[start]=true;//设置该顶点为访问过
        //获取下一个连接顶点
        int nextNeighbour = getFristNeighbour(start);
        while (nextNeighbour!=-1){//存在连接顶点
            if (!isVisited[nextNeighbour]){//顶点没被访问过
                dfs(nextNeighbour);//递归访问该顶点
            }
            nextNeighbour=getNextNeighbour(start,nextNeighbour );
        }
    }
    //深度优先遍历算法重载 每个节点都来一次dsf 防止出现不连通图
    public void dfs(){
        for (int i = 0; i <vertexList.size() ; i++) {
            if (!isVisited[i]){
                dfs(i);
            }
        }
    }

    //广度优先遍历算法
    public void bfs(int start) throws InterruptedException {
        isVisited[start]=true;//设置该顶点为访问过
        vertexQueue.put(start);//第一个元素入队列
        while (vertexQueue.size()>0){//队列中存在元素
            Integer top = vertexQueue.take();//队列头元素
            System.out.println(getVertex(top));
            int nextNeighbour = getFristNeighbour(start);//获取下层顶点
            while (nextNeighbour!=-1){//存在下层顶点
                if (!isVisited[nextNeighbour]){//如果没有遍历过
                    vertexQueue.put(nextNeighbour);//入队列
                    isVisited[nextNeighbour]=true;
                }
                nextNeighbour=getNextNeighbour(top, nextNeighbour);//获取下层顶点的同层后继节点
            }
        }
    }

    //广度优先遍历算法重载 每个节点都来一次dsf 防止出现不连通图
    public void bfs() throws InterruptedException {
        for (int i = 0; i <vertexList.size() ; i++) {
            if (!isVisited[i]){
                bfs(i);
            }
        }
    }
    //显示邻接矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
