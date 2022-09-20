package com.fzz.basicalgorithm.kruskal;

import java.util.Arrays;

//克鲁斯卡尔算法
public class KruskalAlgorithm {
    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;
    private static final int INF=Integer.MAX_VALUE;

    //构造器
    public KruskalAlgorithm(char[] vertexs,int[][] matrix){
        int vlen=vertexs.length;
        this.vertexs=new char[vlen];
        for(int i=0;i<vlen;i++){
            this.vertexs[i]=vertexs[i];
        }

        this.matrix=new int[vlen][vlen];
        for(int j=0;j<vlen;j++){
            for(int m=0;m<vlen;m++){
                this.matrix[j][m]=matrix[j][m];
            }
        }

        //获得边的个数
        for(int i=0;i<vlen;i++){
            for(int j=i+1;j<vlen;j++){
                if(this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }

    }

    private int getEnd(int[] ends, int i) {
        while(ends[i] != 0) {
            i = ends[i];
        }

        return i;
    }

    //获得指定地点对应的下标
    private int getPosition(char ch){
        for(int i=0;i<vertexs.length;i++){
            if(vertexs[i]==ch){
                return i;
            }
        }
        return -1;
    }

    //获得格式化的边的集合
    private Data[] getEdges(){
        int index=0;
        Data[] edges=new Data[this.edgeNum];
        for(int i=0;i< this.vertexs.length;i++){
            for(int j=i+1;j<this.vertexs.length;j++){
                if(this.matrix[i][j]!=INF){
                    edges[index++]=new Data(this.vertexs[i],this.vertexs[j],this.matrix[i][j] );
                }
            }
        }
        return edges;
    }

    //根据权值对边进行排序
    private void sortEdges(Data[] edges){
        Data temp=null;
        for(int i=0;i<edges.length-1;i++){
            for(int j=0;j<edges.length-1-i;j++){
                if(edges[j].weight>edges[j+1].weight){
                    temp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=temp;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;
        int[] ends = new int[this.edgeNum];
        Data[] rets = new Data[this.edgeNum];
        Data[] edges = this.getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共" + edges.length);
        this.sortEdges(edges);

        int i;
        for(i = 0; i < this.edgeNum; ++i) {
            int p1 = this.getPosition(edges[i].begin);
            int p2 = this.getPosition(edges[i].end);
            int m = this.getEnd(ends, p1);
            int n = this.getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        System.out.println("最小生成树为");

        for(i = 0; i < index; ++i) {
            System.out.println(rets[i]);
        }

    }


    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int[][] matrix = new int[][]{
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm( vertexs, matrix);
        kruskalAlgorithm.kruskal();


    }



}

class Data{
    char begin;
    char end;
    int weight;

    public Data(char begin,char end,int weight){
        this.begin=begin;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "Data{" +
                "<" + begin +
                ", " + end +
                ">==" + weight +
                '}';
    }
}

