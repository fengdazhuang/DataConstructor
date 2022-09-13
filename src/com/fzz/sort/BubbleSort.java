package com.fzz.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums= {2,1,6,5,8};
        bubbleSort(nums);
//        for(int m=0;m<nums.length;m++){
//            System.out.print(nums[m]+"\t");
//        }
        System.out.println(Arrays.toString(nums));
    }

    //冒泡排序 时间复杂度：O(n^2)
    public static void bubbleSort(int[] nums){
        boolean flag=false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    flag=true;
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag=false;
            }
        }
    }
}
