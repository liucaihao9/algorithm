package jianzhiOffer;

/**
 * 剪绳子：给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {

    /**
     * 贪心算法的核心就复杂问题分解成若干个小问题，每个小问题的最优解保存下来，最终解得大问题的最优解
     * 解题思路：使用贪心算法解决，f(n) = max{f(n - i) * f(n)} ,0 < i < n
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        //计算当绳子长度小于等于3的最优解
        if (target <= 1){
            throw new IllegalArgumentException();
        }
        if (target == 2){
            return 1;
        }
        if (target == 3){
            return 2;
        }
        int[] products = new int[target + 1];
        //以下保存是减过后每段的基础最优值
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4 ; i <= target ; i++){
            //此处i除以2的原因是超过一半的就是重复计算了，因此没必要重复计算
            for (int j = 1 ; j <= i / 2 ; j++){
                int temp = products[i - j] * products[j];
                if (temp > max){
                    max = temp;
                }
            }
            products[i] = max;
        }
        return products[target];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(4));

        for (int i = 2 ; i < 100 ; i++){
            System.out.println(cutRope(i));
        }
    }
}
