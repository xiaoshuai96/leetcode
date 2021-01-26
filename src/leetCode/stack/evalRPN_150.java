package leetCode.stack;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *     整数除法只保留整数部分。
 *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 *     平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 *     该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 */
public class evalRPN_150 {
    /**
     * 传统做法：双栈
     * 执行用时：9 ms, 在所有 Java 提交中击败了18.13% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了32.81% 的用户
     * @param arr
     * @return
     */
    public int evalRPN(String[] arr) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> symbol = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            //不是运算符直接压入数栈
            if (!arr[i].equals("+") && !arr[i].equals("-") &&
                    !arr[i].equals("*") && !arr[i].equals("/")) {
                nums.push(Integer.parseInt(arr[i]));
            } else {
                //否则，如果数栈中个数大于等于2，弹出做运算，然后将结果压入数栈中
                if (nums.size() >= 2) {
                    int a = nums.pop();
                    int b = nums.pop();
                    String sym = arr[i];
                    if (sym.equals("+")) {
                        nums.push(a + b);
                    } else if (sym.equals("-")) {
                        //后面弹出的减去先弹出的
                        nums.push(b - a);
                    } else if (sym.equals("*")) {
                        nums.push(a * b);
                    } else {
                        //同上
                        nums.push(b / a);
                    }
                } else {//数栈中数个数小于2，直接压入符号栈
                    symbol.push(arr[i]);
                }
            }
        }
        return nums.peek();
    }

    /**
     * 单栈，思路和双栈相同，不废话了直接写
     * 执行用时：8 ms, 在所有 Java 提交中击败了29.27% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了90.27% 的用户
     * @param arr
     * @return
     */
    public int evalRPN02(String[] arr){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("+") && !arr[i].equals("-") &&
                    !arr[i].equals("*") && !arr[i].equals("/")) {
                stack.push(arr[i]);
            } else {
                if (stack.size() > 1) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    String sym = arr[i];
                    if (sym.equals("+")) {
                        stack.push(String.valueOf(a + b));
                    } else if (sym.equals("-")) {
                        //后面弹出的减去先弹出的
                        stack.push(String.valueOf(b - a));
                    } else if (sym.equals("*")) {
                        stack.push(String.valueOf(a * b));
                    } else {
                        //同上
                        stack.push(String.valueOf(b / a));
                    }
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
