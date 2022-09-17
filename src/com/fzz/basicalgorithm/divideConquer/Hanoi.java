package com.fzz.basicalgorithm.divideConquer;

//分治算法解决汉诺塔
public class Hanoi {
    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }

    public static void hanoiTower(int n,char a,char b,char c){
        if(n==1){
            System.out.println(a+"-->"+c);
        }else{
            hanoiTower(n-1,a,c,b);
            System.out.println(a+"-->"+c);
            hanoiTower(n-1,b,a,c);
        }
    }
}
