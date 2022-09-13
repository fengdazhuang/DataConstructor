package com.fzz.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] ={128 ,294 ,133 ,295 ,175 ,8 ,232 ,248 ,241 ,164 ,11 ,60 ,238 ,133 ,291 ,116 ,6 ,67 ,98 ,
                67 ,196 ,260 ,181 ,160 ,83 ,160 ,90 ,153 ,233 ,216};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void quickSort(int arr[] ,int left,int right){
        int l=left;
        int r=right;
        int pivot=arr[(left+right)/2];
        int temp=0;
        while(l<r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if(arr[l]==pivot){
                r--;
            }
            if(arr[r]==pivot){
                l++;
            }
            if(l==r){
                l++;
                r--;
            }
            if(left<r){
                quickSort(arr,left,r);
            }
            if(right>l){
                quickSort(arr,l,right);
            }
        }
    }
}
