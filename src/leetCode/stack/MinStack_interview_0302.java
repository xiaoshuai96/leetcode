package leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack_interview_0302 {
    class MinStack {
        private int num;
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            num = 0;
            stack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int x) {
            stack.push(x);
            //num表示现在栈中存储数据的个数
            if (num > 0){
                int top = minStack.peek();
                if (x < top){
                    minStack.push(x);
                } else {
                    minStack.push(top);
                }
            } else {
                minStack.push(x);
            }
            num++;
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            num--;
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
