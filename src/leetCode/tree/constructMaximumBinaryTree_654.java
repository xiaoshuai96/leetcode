package leetCode.tree;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 *     二叉树的根是数组中的最大元素。
 *     左子树是通过数组中最大值左边部分构造出的最大二叉树。
 *     右子树是通过数组中最大值右边部分构造出的最大二叉树。
 *
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * 提示：
 *
 *     给定的数组的大小在 [1, 1000] 之间。
 */
public class constructMaximumBinaryTree_654 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.93%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了25.00%的用户
     *
     * 1.找终止条件：当l>r时，说明数组中已经没元素了，自然当前返回的节点为null。
     * 2.每一级递归返回的信息是什么：返回的应该是当前已经构造好了最大二叉树的root节点。
     * 3.一次递归做了什么：找当前范围为[l,r]的数组中的最大值作为root节点，
     * 然后将数组划分成[l,bond-1]和[bond+1,r]两段，并分别构造成root的左右两棵子最大二叉树。
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums){
        return buildTree(0,nums.length - 1,nums);
    }
    private static TreeNode buildTree(int start,int end,int[] nums){
        if (start > end) {
            return null;
        }
        int index = findMax(start,end,nums);
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(start,index-1,nums);
        root.right = buildTree(index+1,end,nums);
        return root;
    }
    private static int findMax(int start,int end,int[] nums){
        int max = Integer.MIN_VALUE , index = 0;
        for (int i = start; i <= end ; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
