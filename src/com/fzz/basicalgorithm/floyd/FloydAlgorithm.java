package com.fzz.basicalgorithm.floyd;

import java.util.Arrays;

//弗洛伊德算法
public class FloydAlgorithm {
    private static final int N=65535;

    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int[][] matrix=new int[vertexs.length][vertexs.length];
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
        Graph graph=new Graph(vertexs.length,vertexs,matrix);

        graph.show();
        graph.floyd();
        System.out.println("=============");
        graph.show();
    }

}

class Graph{
    private char[] vertexs;
    private int[][] dis;
    private int[][] pre;

    public Graph(int length,char[] vertexs,int[][] matrix){
        this.vertexs=vertexs;
        this.dis=matrix;
        this.pre=new int[length][length];
        for(int i=0;i<length;i++){
//            for(int j=0;j<length;j++){
//                pre[i][j]=i;
//            }
            Arrays.fill(pre[i],i);
        }

    }

    public void floyd(){
        int temp;
        for(int i=0;i< vertexs.length;i++){
            for(int j=0;j< vertexs.length;j++){
                for(int m=0;m< vertexs.length;m++){
                    temp=dis[i][j]+dis[j][m];
                    if(temp<dis[i][m]){
                        dis[i][m]=temp;
                        pre[i][m]=pre[j][m];
                    }
                }
            }
        }
    }

    public void show(){
        for(int i=0;i< vertexs.length;i++){
            for(int j=0;j< vertexs.length;j++){
                System.out.print(vertexs[i]+"到"+vertexs[j]+"的距离最小为："+dis[i][j]+"\t");

            }
            System.out.println();
        }

        for(int i=0;i< vertexs.length;i++){
            for(int k=0;k< vertexs.length;k++){
                System.out.print(vertexs[pre[i][k]]+"\t");
            }
            System.out.println();
        }
    }
}