package leetCode.Depth_Breadth_FirstSearch;
/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 限制：
 * 0 <= 节点个数 <= 10000
 */
public class isSubStructure_offer_26 {
    /**
     * 算法思想：整体思想是，我们去遍历A树中的每一个节点，将其中的每一个节点都当做是根结点去和B树进行比较
     *
     * 1.当B结点为空时，说明已经完成了对B树的遍历，返回true
     * 2.当A结点为空时，说明已经完成了对A树的遍历，但是还没匹配到B树，这时我们可以确定A树中不存在以B树为子结构的子结构，返回false
     * 3.当A的结点值与B的结点值不相同时，返回false
     *
     * recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
     * 1.recur(A, B)  以A树为开始结点，与B树进行同时遍历
     * 2.isSubStructure(A.left, B) 以A树的左节点为起始节点，递归地进行遍历
     * 3.isSubStructure(A.right, B) 以A树的右节点为起始节点，递归地进行遍历
     *
     * 那么在给出的A B结点中，我们从一开始就需要判断下特殊情况，因为题目中已经告知： 约定空树不是任意一个树的子结构
     * 所以，只要A树为null或者B树为null，返回false即可
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));

    }
    public boolean recur(TreeNode A,TreeNode B){
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
