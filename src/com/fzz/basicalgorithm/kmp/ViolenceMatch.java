package com.fzz.basicalgorithm.kmp;

//暴力匹配算法之寻找相同字符串
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1="我我的我爱java我爱java";//3
        String str2="我爱java";

        int index = match(str1, str2);
        if(index==-1){
            System.out.println("匹配失败");
        }else{
            System.out.printf("匹配成功，初始索引为%d",index);
        }
    }

    public static int match(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i=0;
        int j=0;
        while(i< str1.length()){
            if(s1[i]==s2[j]){
                if(j==s2.length-1){
                    return i-j;
                }
                j++;
                i++;
            }else{
                i=i-(j-1);
                j=0;
            }

        }
        return -1;
    }
}
