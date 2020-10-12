package leetCode.tree;

import leetCode.TreeNode;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 提示：
 *
 *     树中至少有 2 个节点。
 */
public class getMinimumDifference_530 {
    public static void main(String[] args) {

    }
        static int pre;
        static int ans;
        public static int getMinimumDifference(TreeNode root){
            ans = Integer.MAX_VALUE;
            pre = -1;//前一个结点value
            dfs(root);
            return ans;
        }

        /**
         * 二叉搜索树的中序遍历是顺序递增的，比较每两个相邻之间的数字可以得出绝对值最小的差
         * @param root
         */
        private static void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre == -1) {
                pre = root.val;
            } else {
                ans = Math.min(ans, root.val - pre);
                pre = root.val;
            }
            dfs(root.right);
        }
}
