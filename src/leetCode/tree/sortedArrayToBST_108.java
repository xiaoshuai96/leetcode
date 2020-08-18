package leetCode.tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class sortedArrayToBST_108 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了87.76% 的用户
     */
    public static TreeNode sortedArrayToBST(int[] nums){
        return dfs(nums,0,nums.length - 1);
    }
    private static TreeNode dfs(int[] nums,int low,int hight){
        if (low > hight) {
            return null;
        }
        int mid = low + (hight - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,low,mid - 1);
        root.right = dfs(nums,mid + 1,hight);
        return root;
    }
}
