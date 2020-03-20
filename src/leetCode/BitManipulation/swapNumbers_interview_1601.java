package leetCode.BitManipulation;
/**
 *编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 *
 * 提示：
 *
 *     numbers.length == 2
 *
 */
public class swapNumbers_interview_1601 {
    public static void main(String[] args) {
        int[] numbers = {0,1};
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :37.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param numbers
     * @return
     */
    public static int[] swapNumbers(int[] numbers){
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
