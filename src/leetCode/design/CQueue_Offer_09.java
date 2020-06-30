package leetCode.design;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 *     1 <= values <= 10000
 *     最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 *
 *
 * 执行用时：52 ms, 在所有 Java 提交中击败了92.68% 的用户
 * 内存消耗：48.7 MB, 在所有 Java 提交中击败了100.00% 的用户
 */
public class CQueue_Offer_09 {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public static void main(String[] args) {

    }
    public CQueue_Offer_09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    /**
     *
     * @return
     */
    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }
}
