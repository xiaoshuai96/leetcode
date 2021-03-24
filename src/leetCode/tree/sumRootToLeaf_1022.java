package leetCode.tree;

import leetCode.TreeNode;

import java.time.temporal.Temporal;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *
 * 示例 1：
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 示例 2：
 * 输入：root = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：root = [1,1]
 * 输出：3
 *
 *
 * 提示：
 *     树中的结点数介于 1 和 1000 之间。
 *     Node.val 为 0 或 1 。
 */
public class sumRootToLeaf_1022 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

    }
    public int sumRootToLeaf(TreeNode root) {
        return sumBinaryNum(root,"",0);
    }
    private int sumBinaryNum(TreeNode root,String path,int sum){
        if (root != null) {
            StringBuffer sb = new StringBuffer(path);
            sb.append(root.val);
            //到达叶子节点,完成一条路径，计算结果并返回
            if (root.left == null && root.right == null) {
                return sum + cal(sb.toString());
            } else {
                //非叶子节点，继续递归计算
                return sumBinaryNum(root.left, sb.toString(),sum) + sumBinaryNum(root.right, sb.toString(),sum);
            }
        }
        return sum;
    }
    private int cal(String binum){
        int sum = 0,index = 0;
        for (int i = binum.length() - 1; i >= 0; i--) {
            sum += Math.pow(2, index++) * Integer.parseInt(String.valueOf(binum.charAt(i)));
        }
        return sum;
    }


    int ans;
    public int sumRootToLeaf02(TreeNode root) {
        sumbinary(root, 0);
        return ans;
    }

    public void sumbinary(TreeNode root, int cur){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans += cur * 2 + root.val;
            return;
        }
        sumbinary(root.left, cur * 2 + root.val);
        sumbinary(root.right, cur * 2 + root.val);
    }
}
