package com.fzz.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={0,1,2,2,3,3,3,4,5,6,7,8,9};
        int index = binarySearch(arr, 0,arr.length-1,345);
        if(index==-1){
            System.out.println("查找的数不存在");
        }else{
            System.out.println(arr[index]);
        }
    }


    //二分法查找
    public static int binarySearch(int[] arr,int left,int right,int value){
        int mid=(left+right)/2;
        int midValue=arr[mid];
        if(value==midValue) return mid;

        if(value<midValue&&value>=arr[left]){
            return binarySearch(arr,left,mid,value);
        }
        if(value>midValue&&value<=arr[right]){
            return binarySearch(arr,mid,right,value);
        }
        return -1;

    }
}
