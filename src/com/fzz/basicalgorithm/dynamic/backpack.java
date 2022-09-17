package com.fzz.basicalgorithm.dynamic;


//动态规划算法之背包问题
public class backpack {
    public static void main(String[] args) {

        int[] v={1500,3000,2000};
        int[] w={1,4,3};
        int maxValue = dynamicConquer(v, w, 4);
        System.out.println(maxValue);
    }

    public static int dynamicConquer(int[] v,int[] w,int maxWeight){
        int[][] valueSum=new int[v.length+1][maxWeight+1];

        int[][] path=new int[v.length+1][maxWeight+1];
        for(int i=0;i<v.length+1;i++){
            for(int j=0;j<maxWeight+1;j++){
                if(i==0||j==0){
                    valueSum[i][j]=0;
                }else{
                    if(w[i-1]>j){
                        valueSum[i][j]=valueSum[i-1][j];
                    }else{
                        if(valueSum[i-1][j]<v[i-1]+valueSum[i-1][j-w[i-1]]){
                            valueSum[i][j]=v[i-1]+valueSum[i-1][j-w[i-1]];
                            path[i][j]=1;
                        }else{
                            valueSum[i][j]=valueSum[i-1][j];
                        }
                    }
                }

            }
        }
        for(int m=0;m<valueSum.length;m++){
            for(int k=0;k<valueSum[0].length;k++){
                System.out.print(valueSum[m][k]+"\t");
            }
            System.out.println();
        }


        int i= path.length-1;//行的最大下标，i表示第商品序号
        int j=path[0].length-1; //列的最大下标，j表示容量
        while(i>0&&j>0){
            if(path[i][j]==1){
                System.out.printf("第%d个商品放入背包\n",i);
                j=j-w[i-1];
            }
            i--;
        }

        return valueSum[v.length][maxWeight];
    }
}
