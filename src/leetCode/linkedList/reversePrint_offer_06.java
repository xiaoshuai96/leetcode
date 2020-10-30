package leetCode.linkedList;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class reversePrint_offer_06 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了40.53% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了67.31% 的用户
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head){
        //如果头节点为空或者头节点的下一个节点为null，直接返回一个空数组或者包含头节点值的数组
        if(head == null) return new int[]{};
        if(head.next == null) return new int[]{head.value};
        //复制一份头节点
        ListNode dummy = head;
        Stack<Integer> stack = new Stack<>();
        //将链表中每个结点的值压入栈中
        while(dummy != null){
            stack.push(dummy.value);
            dummy = dummy.next;
        }
        int[] res = new int[stack.size()];
        int count = 0;
        //将栈中的数字弹出依次放入res数组中，最后返回
        while(!stack.isEmpty()){
            res[count++] = stack.pop();
        }
        return res;
    }
}
