package com.fzz.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序  不能用负数
    public static void radixSort(int[] arr){
        int max=arr[0];
        for(int m=1;m<arr.length;m++){
            if(max<arr[m]){
                max=arr[m];
            }
        }
        int len=(max+"").length();

        for(int j=0,n=1;j<len;j++,n=n*10){
            int[][] bucket=new int[10][arr.length];
            int[] counts=new int[10];
            for(int i=0;i<arr.length;i++){
                int temp=arr[i]/n%10;
                bucket[temp][counts[temp]]=arr[i];
                counts[temp]++;
            }
            int index=0;
            for(int k=0;k< bucket.length;k++){
                for(int h=0;h<counts[k];h++){
                    arr[index]=bucket[k][h];
                    index++;
                }
            }
        }


    }
}
