package graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Halo
 * @date Created in 2021/08/25 上午 10:42
 * @description 邻接矩阵表示图数据结构
 */
public class Graph {
    // 用于存储顶点的集合
    private ArrayList<String> vertexList;
    // 用于存储图对应的邻接矩阵
    private int[][] edges;
    // 表示边的数目
    private int numOfEdges;

    // 构造器
    public Graph(int n) {
        // 初始化
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    /**
     * 插入节点
     *
     * @param vertex 节点名称
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     节点1的索引
     * @param v2     节点2的索引
     * @param weight 权重
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // 图的常用方法

    /**
     * @return 节点的个数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * @return 边的个数
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * @param i 节点的索引
     * @return 节点 i 对应的数据
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * @param v1 节点1的索引
     * @param v2 节点2的索引
     * @return v1 和 v2 的边的权值
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public static void main(String[] args) {
        // 节点的数目
        int n = 5;
        String[] vertexes = {"A", "B", "C", "D", "E"};
        // 创建图对象
        Graph graph = new Graph(n);
        // 添加顶点
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        // 添加边
        // A-B、A-C、B-C、B-D、B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        // 显示邻接矩阵
        graph.showGraph();
    }
}
