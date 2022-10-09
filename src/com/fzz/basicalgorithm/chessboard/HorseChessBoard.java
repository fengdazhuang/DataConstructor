package com.fzz.basicalgorithm.chessboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


//骑士周游算法+贪心算法优化
public class HorseChessBoard {

    //列数
    private static int X;
    //行数
    private static int Y;

    private static boolean[] isVisited;

    private static boolean isFinished;


    public static void main(String[] args) {
        System.out.println("骑士周游算法：");
        X=8;
        Y=8;
        int row=1;
        int column=1;
        int[][] chessBoard=new int[X][Y];
        isVisited=new boolean[X*Y];
        horse(row-1,column-1,1,chessBoard);

        for(int[] rows:chessBoard){
            for(int step:rows){
                System.out.print(step+"\t");
            }
            System.out.println();
        }
    }

    public static void horse(int row,int column,int step,int[][] chessBoard){
        chessBoard[row][column]=step;

        isVisited[row*X+column]=true;
        ArrayList<Point> next = next(new Point(column, row));
        sort(next);
        while(!next.isEmpty()){
            Point point = next.remove(0);
            if(!isVisited[point.y*X+point.x]){
                horse(point.y,point.x,step+1,chessBoard);
            }
        }
        if(step<X*Y&&!isFinished){
            chessBoard[row][column]=0;
            isVisited[row*X+column]=false;

        }else{
            isFinished=true;
        }
    }

    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> list=new ArrayList<>();
        Point p = new Point();
        if((p.x=curPoint.x-1)>=0&&(p.y=curPoint.y-2)>=0){
            list.add(new Point(p));
        }
        if((p.x=curPoint.x+1)<=X-1&&(p.y=curPoint.y-2)>=0){
            list.add(new Point(p));
        }
        if((p.x=curPoint.x-2)>=0&&(p.y=curPoint.y-1)>=0){
            list.add(new Point(p));
        }
        if((p.x=curPoint.x+2)<=X-1&&(p.y=curPoint.y-1)>=0){
            list.add(new Point(p));
        }
        if((p.x=curPoint.x-1)>=0&&(p.y=curPoint.y+2)<=Y-1){
            list.add(new Point(p));
        }
        if((p.x=curPoint.x+1)<=X-1&&(p.y=curPoint.y+2)<=Y-1){
            list.add(new Point(p));
        }
        if((p.x=curPoint.x-2)>=0&&(p.y=curPoint.y+1)<=Y-1){
            list.add(new Point(p));
        }
        if((p.x=curPoint.x+2)<=X-1&&(p.y=curPoint.y+1)<=Y-1){
            list.add(new Point(p));
        }

        return list;

    }

    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1=next(o1).size();
                int count2=next(o2).size();
                if(count1<count2){
                    return -1;
                }else if(count1==count2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    }
}
