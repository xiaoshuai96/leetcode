package leetCode.linkedList;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class isPalindrome_interview_0206 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了47.60% 的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了77.13% 的用户
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //分割
        ListNode slow = head,fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode before = head;
        ListNode after = slow.next;
        //翻转
        ListNode reverse = reverse(after);
        //两个指针进行比较
        ListNode p1 = head,p2 = reverse;
        boolean flag = true;
        while (p2 != null && flag){
            if (p1.value != p2.value) {
                flag = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //恢复
        slow.next = reverse(reverse);
        return flag;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;//存放当前结点的前一个结点
        ListNode curr = head;//存放当前结点
        while (curr != null) {
            ListNode next = curr.next;//该结点存储当前结点的下一个结点
            curr.next = prev;//当前结点的下一结点指向前一个结点
            prev = curr;//然后将当前结点赋值给前一个结点
            curr = next;//移动当前结点curr的位置
        }
        return prev;
    }
}
