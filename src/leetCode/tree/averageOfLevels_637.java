package leetCode.tree;

import java.util.*;
import leetCode.TreeNode ;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 *
 *
 * 提示：
 *
 *     节点值的范围在32位有符号整数范围内。
 */
public class averageOfLevels_637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
        List<Double> list = averageOfLevels(root);
        for (Double a : list) {
            System.out.print("\t "+a);
        }
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了73.65% 的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了99.29% 的用户
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels(TreeNode root){
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            double sum = 0;
            /**
             * 将栈中的节点拿出，一边判断节点是否存在左右子节点，一边将当前层所有节点的值的和求出
             */
            for (int i = 0; i < size; i++) {
                TreeNode temp = stack.poll();
                if (temp.left != null) {
                    stack.add(temp.left);
                }
                if (temp.right != null) {
                    stack.add(temp.right);
                }
                sum += temp.val;
            }
            double d = sum / size;
            res.add(d);
        }
        return res;
    }
}
