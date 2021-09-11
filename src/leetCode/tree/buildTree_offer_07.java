package leetCode.tree;

import leetCode.TreeNode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class buildTree_offer_07 {
    int[] preorder;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //将中序遍历的
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0,0,inorder.length - 1);

    }

    /**
     * inorder = [9,3,15,20,7]
     *
     * 中序遍历特点：  左、   根、    右
     *               9     3     15,20,7
     *
     * @param root
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper(int root,int left,int right){
        //递归中止条件
        if (left > right) return null;
        //建立根结点
        TreeNode node = new TreeNode(preorder[root]);
        //获取根结点值在中序遍历数组中的下标
        int i = map.get(preorder[root]);
        //向左边遍历
        node.left = helper(root + 1, left, i + 1);
        //向右边遍历
        node.right = helper(root + i - left + 1, i + 1, right);
        return node;
    }
}
