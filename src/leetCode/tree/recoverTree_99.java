package leetCode.tree;

import leetCode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * 进阶:
 *
 *     使用 O(n) 空间复杂度的解法很容易实现。
 *     你能想出一个只使用常数空间的解决方案吗？
 */
public class recoverTree_99 {
    public static void main(String[] args) {

    }

    /**
     *
     * 执行用时：4 ms, 在所有 Java 提交中击败了31.16% 的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了45.72% 的用户
     *
     * 思路：
     * 二叉搜索树通过中序遍历之后得到的是一串递增的数，
     * 例如：正常情况下我们得到的是：[1,2,3,4,5,6] 每个数都满足arr[i+1] > arr[i]
     * 被破坏的树中序遍历的结果：[1,6,3,4,5,2] 但是这里1号位置和5号位置是不符合要求的，这时我们就发现了
     * 不满足条件的两个节点，我们记录下来他们的值，然后去到被破坏的树中交换他们的位置。
     * @param root
     */
    public void recoverTree01(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int[] swapped = findTwoSwapped(list);
        recover(root,2,swapped[0],swapped[1]);
    }

    /**
     * 中序遍历树,将遍历到的值都存储到list中
     */
    private void inorder(TreeNode root, List<Integer> list){
        if (root == null) {
            return ;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    /**
     * 找到两个不符合条件的值
     * @param list
     * @return
     */
    private int[] findTwoSwapped(List<Integer> list){
        int x = -1, y = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            //符合条件(如果后一个数字小于前一个数字)
            if (list.get(i + 1) < list.get(i)) {
                y = list.get(i + 1);
                if (x == -1) {
                    x = list.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    /**
     *
     * @param root
     * @param count 记录次数
     * @param x
     * @param y
     */
    private void recover(TreeNode root,int count,int x,int y){
        if (root != null) {
            if (root.val == x || root.val == y) {
                //如果当前结点的值以前等于x，现在给换成y；否则反之
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.left,  count, x, y);
            recover(root.right, count, x, y);
        }
    }


    /**
     * 使用ArrayDeque来进行节点存储
     *
     * @param root
     */
    public void recoverTree02(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
