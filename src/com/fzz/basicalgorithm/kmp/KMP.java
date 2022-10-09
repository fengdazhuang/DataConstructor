package com.fzz.basicalgorithm.kmp;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1="BCDADBCBADBCADDAC";
        String str2="ADBCA";
        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));
        int i = kmpSearch(str1, str2, next);
        if(i!=-1){
            System.out.println("匹配的起始索引为："+i);
        }else{
            System.out.println("匹配失败");
        }

    }

    public static int kmpSearch(String str1,String str2,int[] next){
        for(int i=0,j=0;i<str1.length();i++){
            while(j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }


    public static int[] kmpNext(String str){
        int[] next=new int[str.length()];
        next[0]=0;
        for(int i=1,j=0;i<str.length();i++){
            while(j>0&&str.charAt(i)!=str.charAt(j)){
                j=next[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
