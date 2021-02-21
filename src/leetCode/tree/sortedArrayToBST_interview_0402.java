package leetCode.tree;

import leetCode.TreeNode;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 */
public class sortedArrayToBST_interview_0402 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了93.36% 的用户
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }
    private TreeNode helper(int[] nums,int low,int high){
        //子数组范围小于1了，直接返回null即可
        if(low > high){
            return null;
        }
        //子树中间结点值
        int mid = (high - low) / 2 + low;
        TreeNode root = new TreeNode(nums[mid]);
        //左子树
        root.left = helper(nums, low, mid - 1);
        //右子树
        root.right = helper(nums, mid + 1, high);
        return root;
    }
}
