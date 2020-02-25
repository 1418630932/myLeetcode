package Algorithm.primAlgorithm;

/**普利姆算法
 * @author zhuliyang
 * @date 2020-01-21
 * @time 22:32
 **/
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'a','b','c','d','e','f','g'};
        int verx = data.length;
        int[][] weight={{10000,5,7,10000,100000,10000,2,},
                        {5,10000,10000,9,10000,10000,3},
                        {7,10000,10000,10000,8,10000,1000},
                        {10000,9,10000,10000,10000,4,10000},
                        {10000,10000,8,10000,10000,5,4},
                        {10000,10000,10000,4,5,10000,6},
                        {2,3,10000,10000,4,6,10000},
                        };
        Mgraph mgraph = new Mgraph(verx);
        mgraph.setData(data);
        mgraph.setWeight(weight);
        MinTree minTree = new MinTree();
        minTree.prim(mgraph,1 );
    }
}
class MinTree{
    /**
     * 得到最小生成树
     * @param mgraph 图
     * @param startIndex 起始顶点的索引
     */
    public void prim(Mgraph mgraph,int startIndex){
        int[] visited = new int[mgraph.getVerxs()];//顶点访问记录数组  0：未访问  1：访问过
        char[] data = mgraph.getData();
        int minPath = Integer.MAX_VALUE;//最小路径
        visited[startIndex]=1;//设置起始顶点已经被访问过
        int h1=-1;
        int h2 =-1;
        for (int i = 0; i <mgraph.getVerxs()-1 ; i++) {//n个顶点 求n-1条边
            for (int j = 0; j <mgraph.getVerxs() ; j++) {//遍历所有顶点之间的关系
                if (visited[j]==1){//如果是以访问的顶点
                    for (int k = 0; k <mgraph.getVerxs() ; k++) {
                        if (visited[k]==0&&mgraph.getWeight()[j][k]<minPath){//如果是为访问的顶点并且路径比当前最短路径还要小
                            minPath=mgraph.getWeight()[j][k];//最小路径
                            h1=j;
                            h2=k;
                        }
                    }
                }
            }
            System.out.println(data[h1]+"--->"+data[h2]+"    : "+minPath);
            visited[h2]=1;//最小路径的第二个节点设置为已访问过
            minPath=Integer.MAX_VALUE;//初始化
        }
    }

}
class Mgraph{
    int verxs;//图的顶点个数
    char[] data;//存放的节点数据
    int[][] weight;//存放边 邻接矩阵
    public Mgraph(int verxs){
        this.verxs=verxs;
        this.data = new char[verxs];
        this.weight=new int[verxs][verxs];
    }

    public int getVerxs() {
        return verxs;
    }

    public void setVerxs(int verxs) {
        this.verxs = verxs;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public int[][] getWeight() {
        return weight;
    }

    public void setWeight(int[][] weight) {
        this.weight = weight;
    }
}
