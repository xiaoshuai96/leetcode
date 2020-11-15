package leetCode.greedy;

import java.util.Deque;
import java.util.LinkedList;

/**
 *给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 *     num 的长度小于 10002 且 ≥ k。
 *     num 不会包含任何前导零。
 *
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class removeKdigits_402 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了60.67% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了81.91% 的用户
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num,int k){
        Deque<Character> deque = new LinkedList<Character>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            //如果当前栈不为空并且k > 0 和 栈底的最后一个元素始终大于要遍历的该数
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        //如果上述条件结束之后k还是没有等于0，那么说明这时栈中的元素都是递增的了
        //要满足题意就需要就将最后的k位元素移除
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        /**
         * 最后就将栈中剩下的元素添加到字符串中并返回
         * 要注意前导0的存在
         * leadingZero就是记录第一个元素是否是前导0
         * 如果是，跳过此次循环，向后找到一个不是前导0的数字
         * 否则，依次添加中sb字符串
         */
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            Character digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
