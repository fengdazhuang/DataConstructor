package com.fzz.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums= {8,9,1,7,2,3,5,4,6,0};
//        shellSort1(nums);

        shellSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    //希尔排序法(简单插入法的进阶)   1：交换法
    public static void shellSort1(int[] nums){
        int length=nums.length;
        int temp;
        for(int gap=length/2;gap>0;gap=gap/2){
            for(int i=gap;i<length;i++){
                for(int j=i-gap;j>=0;j-=gap){
                    if(nums[j]>nums[j+gap]){
                        temp=nums[j+gap];
                        nums[j+gap]=nums[j];
                        nums[j]=temp;
                    }
                }
            }
        }
    }

    //2：移动法(对交换法进行优化)
    public static void shellSort2(int[] arr){
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int insertVal=arr[j];
                if(insertVal<arr[j-gap]){
                    while(j-gap>=0&&insertVal<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j=j-gap;
                    }
                    arr[j]=insertVal;
                }

            }
        }
    }
}
