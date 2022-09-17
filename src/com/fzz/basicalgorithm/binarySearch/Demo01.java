package com.fzz.basicalgorithm.binarySearch;

public class Demo01 {
    public static void main(String[] args) {
        int[] arr={0,1,2,2,3,3,3,4,5,6,7,8,9};
        int index = binarySearch(arr,4);
        if(index==-1){
            System.out.println("查找的数不存在");
        }else{
            System.out.println("arr["+index+"]="+arr[index]);
        }
    }

    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                left=mid+1;
            }
            if(arr[mid]>target){
                right=mid-1;
            }

        }
        return -1;
    }
}
