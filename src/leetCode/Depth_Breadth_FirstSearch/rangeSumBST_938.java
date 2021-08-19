package leetCode.Depth_Breadth_FirstSearch;


/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 *
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 *
 *
 * 提示：
 *
 *     树中的结点数量最多为 10000 个。
 *     最终的答案保证小于 2^31。
 */
public class rangeSumBST_938 {
    static int ans = 0;
    public static void main(String[] args) {

    }

    /**
     * 对树进行深度优先搜索，对于当前结点，如果node.value小于L，只需要搜索它的右子树即可
     * 如果node.value大于等于R,只需要搜索它的左子树即可
     * 如果node.value的值存在于L和R之间，则搜索它的所有子树
     *
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :48.9 MB, 在所有 Java 提交中击败了5.16%的用户
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root,L,R);
        return ans;
    }
    public static void dfs(TreeNode node,int L,int R){
        if (node != null) {
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            }
            if (node.val > L) {
                dfs(node.right,L,R);
            }
            if (node.val <= R) {
                dfs(node.left,L,R);
            }
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }
}

