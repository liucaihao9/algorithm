package jianzhiOffer;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

/**
 * 思路：按照题目要求划分就是了
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (size <= 0 || size > num.length){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0 ; i + size <= num.length ; i++){
            int j = i;
            int max = Integer.MIN_VALUE;
            for (int temp = 0; temp < size ; temp++){
                max = max > num[j + temp] ? max : num[j + temp];
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        MaxInWindows maxInWindowsObj = new MaxInWindows();
        System.out.println(maxInWindowsObj.maxInWindows(num , 3));
    }
}
