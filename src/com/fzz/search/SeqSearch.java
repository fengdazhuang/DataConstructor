package com.fzz.search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr={1,34,5,7,3,46};

        int index = seqSearch(arr, 2);
        if(index==-1){
            System.out.println("查找的数不存在");
        }else{
            System.out.println(arr[index]);
        }



    }

    public static int seqSearch(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
