package jianzhiOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int index = 0;
        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                //每次起点都初始化一个set保存正确走过的路径
                Set<String> hasWent = new HashSet<String>();
                if (hasPathCore(index , i , j , rows , cols , str , matrix , hasWent)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasPath hasPathObj = new HasPath();
        String matrixStr = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String str = "SLHECCEIDEJFGGFIE";
        System.out.println(hasPathObj.hasPath(matrixStr.toCharArray() , 5 , 8 , str.toCharArray()));
    }

    /**
     *
     * @param index 当前计算的字符串的下标
     * @param i 当前横坐标
     * @param j 当前纵坐标
     * @param rows 行数
     * @param cols 列数
     * @param str 目标的字符串
     * @param matrix 整个矩阵组成的字符串
     */
    public boolean hasPathCore(int index , int i , int j , int rows , int cols , char[] str , char[] matrix , Set<String> hasWent){
        //超出了矩阵，那肯定是false
        if (i < 0  || i > rows - 1 || j < 0 || j > cols - 1){
            return false;
        }
        //重复走过的路径，肯定也是false
        if (hasWent.contains(i + "," + j)){
            return false;
        }
        //当前要找的值与当前矩阵的值不等，那么也肯定是false
        if (str[index] != matrix[i * cols + j]){
            return false;
        }
        //当前下标的值与矩阵的值相等，说明是需要走的路径
        hasWent.add(i + "," + j);
        //当前记录的长度和要找字符串的长度相同，说明走过的路径构成的字符串是要找的字符串，返回true
        if (index == str.length - 1){
            return true;
        }
        //说明找到了部分路径，并且找到的部分路径都是对的，那么接下来继续递归找上下左右这些路径
        index++;
        if (hasPathCore(index , i + 1 , j , rows , cols , str , matrix , hasWent)) return true;
        if (hasPathCore(index , i - 1 , j , rows , cols , str , matrix , hasWent)) return true;
        if (hasPathCore(index , i , j + 1 , rows , cols , str , matrix , hasWent)) return true;
        if (hasPathCore(index , i , j - 1 , rows , cols , str , matrix , hasWent)) return true;
        //上下左右都走了，并且都找不到正确的值
        return false;
    }
}
