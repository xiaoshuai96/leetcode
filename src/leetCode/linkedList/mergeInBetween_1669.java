package leetCode.linkedList;
/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 * 下图中蓝色边和节点展示了操作后的结果：
 * 请你返回结果链表的头指针。
 *
 *
 * 示例 1：
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 *
 * 示例 2：
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 =
 * [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *
 *
 * 提示：
 *     3 <= list1.length <= 10^4
 *     1 <= a <= b < list1.length - 1
 *     1 <= list2.length <= 10^4
 */
public class mergeInBetween_1669 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：42.1 MB, 在所有 Java 提交中击败了94.50% 的用户
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        /**
         * 找到第a个结点的前驱结点和第b个结点的后继结点
         * a的前驱结点的next指向list2的头节点，
         * list2的最后一个节点的next指向b的后继结点
         **/
        ListNode head1 = list1;
        ListNode last1 = list1;
        for(int i = 0;i < a - 1;i++){
            head1 = head1.next;
        }
        //从a的位置继续开始，没必要从头开始
        last1 = head1.next;
        for(int i = a;i <= b;i++){
            last1 = last1.next;
        }
        //先把list2的头节点给接到第a个结点的前驱结点后面
        head1.next = list2;
        ListNode head2 = list2;
        //拿到list2链表的最后一个节点
        while(head2.next != null){
            head2 = head2.next;
        }
        head2.next = last1;
        return list1;
    }
}
