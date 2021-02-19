package leetCode.linkedList;

/**
 * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
 *
 *
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 */
public class deleteNode_interview_0203 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :38.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param node
     */
    public static void deleteNode(ListNode node){
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了15.97% 的用户
     * @param node
     */
    public void deleteNode02(ListNode node) {
        //将当前节点的后一个节点值赋值给当前节点
        node.val = node.next.val;
        //然后将当前节点的next指针指向当前节点的下一个节点的下一个节点
        node.next = node.next.next;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
