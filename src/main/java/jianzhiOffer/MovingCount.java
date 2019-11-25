package jianzhiOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols){
        Set<String> successVisit = new HashSet<String>();
        Set<String> hasVisit = new HashSet<String>();
        checkInColAndRow(threshold , hasVisit , successVisit , 0 , 0 , cols , rows);
        for (String s : successVisit) {
            System.out.println(s);
        }
        return successVisit.size();
    }

    private void checkInColAndRow(int threshold, Set<String> hasVisit ,Set<String> successVisit, int col, int row , int cols , int rows) {
        if (hasVisit.contains(col + "," + row)){
            return;
        }
        if (row >= 0 && row <= rows && col >= 0 && col <= cols){
            int tempRow = row;
            int tempCol = col;
            int sum = 0;
            while (tempRow != 0){
                sum = sum + tempRow % 10;
                tempRow = tempRow / 10;
            }
            while (tempCol != 0){
                sum = sum + tempCol % 10;
                tempCol = tempCol / 10;
            }
            hasVisit.add(col + "," + row);
            if (sum <= threshold){
                //本身是可达的
                successVisit.add(col + "," + row);
                checkInColAndRow(threshold , hasVisit ,successVisit , col - 1 , row , cols , rows);
                checkInColAndRow(threshold , hasVisit ,successVisit , col + 1 , row , cols , rows);
                checkInColAndRow(threshold , hasVisit ,successVisit , col , row - 1 , cols , rows);
                checkInColAndRow(threshold , hasVisit ,successVisit , col , row + 1 , cols , rows);
            }

        }
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        int all = movingCount.movingCount(15 , 20 , 20);
        System.out.println(all);
    }
}
