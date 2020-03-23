package leetCode.linkedList;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *

 * 提示：
 *
 *     给定链表的结点数介于 1 和 100 之间。
 *
 */
public class middleNode_876 {
    public static void main(String[] args) {

    }

    /**
     * 单指针：
     * 传统思路：先遍历统计这条链表的长度，然后根据长度二次遍历定位到中间结点并返回。
     * 不过这种做法并不推荐，主要是因为代码繁杂，虽然思路容易理解，但是不优雅
     *
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了5.05%的用户
     * @param head
     * @return
     */
    public static ListNode middleNode01(ListNode head){
        if(head == null) return null;
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        count =(count/2)+1;
        while(count > 1){
            head = head.next;
            count--;
        }
        return head;
    }

    /**
     * 既然题意中已经规定了链表的极限长度，那么我们可以使用ListNode类型的数组保存该链表的每个结点
     * 之后根据最后一个结点的下标来得到中间结点的下标并返回该结点
     *
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.2 MB, 在所有 Java 提交中击败了5.05%的用户
     * @param head
     * @return
     */
    public static ListNode middleNode02(ListNode head){
        ListNode[] ls = new ListNode[100];
        int count = 0;
        while (head != null) {
            ls[count++] = head;
            head = head.next;
        }
        return ls[count/2];

    }

    /**
     * 第三种方法：快慢指针
     * 快慢指针：同时使用一快一慢两个指针，刚开始指向的都是头节点，开始之后，快指针的速度是慢指针的两倍
     * 直到快指针走到链表末尾，这时慢指针指向的正好是中间结点
     *
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了5.05%的用户
     * @param head
     * @return
     */
    public static ListNode middleNode03(ListNode head){
        ListNode fast = head,low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;

    }
}
