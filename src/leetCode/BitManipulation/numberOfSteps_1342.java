package leetCode.BitManipulation;

/**
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
 * 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 * 示例 1：
 *
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 *
 * 示例 3：
 *
 * 输入：num = 123
 * 输出：12
 *
 * 提示：
 *     0 <= num <= 10^6
 */
public class numberOfSteps_1342 {
    public static void main(String[] args) {
        int i = numberOfSteps(25);
        System.out.println(i);
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :37 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param num
     * @return
     */
    public static int numberOfSteps(int num){
        int count = 0;
        while(num != 0){
            if(num % 2 == 0){
                num = num >> 1;
                count++;
            }else{
                num -= 1;
                count++;
            }
        }
        return count;
    }
}
