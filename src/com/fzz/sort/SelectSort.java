package com.fzz.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums= {2,1,6,5,8};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    //选择排序  时间复杂度：O(n^2)
    public static void selectSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int min=nums[i];
            int minIndex=i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<min){
                    min=nums[j];
                    minIndex=j;
                }
            }

            if(minIndex!=i){
                nums[minIndex]=nums[i];
                nums[i]=min;
            }
        }
    }
}
