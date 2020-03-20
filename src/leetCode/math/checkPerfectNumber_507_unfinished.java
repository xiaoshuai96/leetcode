package leetCode.math;

import java.util.ArrayList;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 *
 *
 * 示例：
 *
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 *
 *
 *
 * 提示：
 *
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 *
 *
 * 思路：
 * 1.得到这个数的所有正因子
 * 2.然后将这些正因子之后和该数进行比较
 * 3.返回结果
 */
public class checkPerfectNumber_507_unfinished {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(100000000));
    }
    public static boolean checkPerfectNumber(int num){
        switch(num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }
}
