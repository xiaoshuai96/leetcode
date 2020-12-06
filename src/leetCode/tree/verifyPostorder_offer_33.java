package leetCode.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 提示：
 *     数组长度 <= 1000
 * 算法思路：
 * 二叉搜索树的后续遍历顺序为：左节点、右节点、根节点
 * 数组的最后一个元素就是根节点，找到数组中第一个大于根节点的节点，这样
 * 就可以划分左右子树，然后每个部分再按照上面的步骤进行划分
 */
public class verifyPostorder_offer_33 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了81.81% 的用户
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recursion(postorder, 0, postorder.length - 1);
    }
    private boolean recursion(int[] postorder, int i, int j) {
        //节点个数小于1个的时候无需判断直接返回true即可
        if (i >= j) return true;
        int p = i;
        //找出根节点的右子树根节点，确定根节点的左子树范围
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        //找出根节点的左子树根节点，确定根节点的右子树范围
        while (postorder[p] > postorder[j]) p++;
        return p == j && recursion(postorder, i, m - 1) && recursion(postorder, m, j - 1);
    }
}
