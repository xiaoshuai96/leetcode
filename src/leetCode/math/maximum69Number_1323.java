package leetCode.math;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * 请返回你可以得到的最大数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 *
 * 示例 2：
 *
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 *
 * 示例 3：
 *
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 *
 *
 *
 * 提示：
 *
 *     1 <= num <= 10^4
 *     num 每一位上的数字都是 6 或者 9 。
 */
public class maximum69Number_1323 {
    public static void main(String[] args) {
        int i = maximum69Number(9999);
        System.out.println(i);
    }

    public static int maximum69Number(int num) {
        String s = (num + "");
        String[] split = s.split("");
        for (int j = 0;j < split.length;j++) {
            if ("6".equals(split[j])) {
                split[j] = "9";
                break;
            }
        }
        String res = "";
        for (String a : split) {
            res += a;
        }
        return Integer.parseInt(res);

    }
}
