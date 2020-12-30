package leetCode.BitManipulation;
/**
 * 编写一个方法，找出两个数字a和b中最大的那一个。
 * 不得使用if-else或其他比较运算符。
 *
 * 示例：
 *
 * 输入： a = 1, b = 2
 * 输出： 2
 */
public class maximum_interview_1607 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.2 MB, 在所有 Java 提交中击败了64.80% 的用户
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        int res = (int) ((Math.abs(c-d) + c + d)/2);
        return res;
    }
}
