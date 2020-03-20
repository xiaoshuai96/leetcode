package leetCode.recursion;
/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 */
public class addDigits_258 {
    public static void main(String[] args) {
        int i = addDigits02(18);
        System.out.println(i);
    }
    //recursion
    public static int addDigits01(int num){
        if(num < 10){
            return num;
        }
        int count = 0;
        while(num != 0){
            count += (num%10);
            num /= 10;
        }
        return addDigits01(count);
    }

    /**
     * input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
     * output:1 2 3 4 5 6 7 8 9 1  2  3  4  5  6  7  8  9  1  2  3  4  5  6  7  8  9  1  2  3
     * 可以看到上面的输入和输出是有一定的对应关系的，从1到9
     *
     * 执行用时 :2 ms, 在所有 Java 提交中击败了31.13% 的用户
     * 内存消耗 :37 MB, 在所有 Java 提交中击败了5.01%的用户
     * @param num
     * @return
     */
    public static int addDigits02(int num){
        return num<10?num:((num%9)==0?9:num%9);
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.01%的用户
     * @param num
     * @return
     */
    public static int addDigits03(int num){
        return (num - 1)%9 + 1;
    }
}
