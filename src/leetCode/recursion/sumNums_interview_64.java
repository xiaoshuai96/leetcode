package leetCode.recursion;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 *  及条件判断语句（A?B:C）。
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 限制：
 *
 *     1 <= n <= 10000
 */
public class sumNums_interview_64 {
    public static void main(String[] args) {

    }

    /**
     * 本题的要求主要是不能使用乘除和关键字，首先想到的就是递归解决，可以利用短路&&来进行
     * @param n
     * @return
     */
    int res = 0;
    public int sumNums(int n){
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
