package leetCode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class dailyTemperatures_739 {
    public static void main(String[] args) {
        int[] T = {55,38,53,81,61,93,97,32,43,78};
        //         3  1  1  2  1  1  0  1  1  0
        int[] temperatures = dailyTemperatures02(T);
        System.out.println(Arrays.toString(temperatures));
    }

    /**
     * 哭晕在厕所……
     * 执行用时 :1349 ms, 在所有 Java 提交中击败了5.02% 的用户
     * 内存消耗 :48 MB, 在所有 Java 提交中击败了6.45%的用户
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int count = 0;
        for(int i = 0;i < res.length-1;i++){
            for(int j = i + 1;j < res.length;j++){
                if(T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 单调栈
     *      *  -  *
     *      *  -  *
     *      *  -  *
     *      *  -  *
     *      *  -  *
     *      *******
     * @param T
     * @return
     */
    public static int[] dailyTemperatures02(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

}
