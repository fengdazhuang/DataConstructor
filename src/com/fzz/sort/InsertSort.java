package com.fzz.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums= {2,1,6,5,8};
//        int[] res = insertSort(nums);
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    //插入排序  时间复杂度：
    public static void insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int insertVal=nums[i];
            int index=i-1;
            while(index>=0&&insertVal<nums[index]){
                nums[index+1]=nums[index];
                index--;
            }
            nums[index+1]=insertVal;
        }
    }


//    public static int[] insertSort(int[] nums){
//        int[] arr=new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            int insertVal=nums[i];
//            int index=i-1;
//            while(index>=0&&insertVal<nums[index]){
//                arr[index+1]=arr[index];
//
//                index--;
//            }
//            arr[index+1]=insertVal;
//        }
//        return arr;
//    }

}
