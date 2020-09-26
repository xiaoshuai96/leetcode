package leetCode.tree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 *
 *     结点左子树中所含结点的值小于等于当前结点的值
 *     结点右子树中所含结点的值大于等于当前结点的值
 *     左子树和右子树都是二叉搜索树
 *
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 */
public class findMode_501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = null;
        int[] mode = findMode(root);
        System.out.println(Arrays.toString(mode));
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了14.67% 的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了5.24% 的用户
     */
    static Map<Integer,Integer> map = new HashMap<>();
    public static int[] findMode(TreeNode root){
        dfs(root);
        int v = 0;
        for (Integer key : map.keySet()){
            if (map.get(key) > v) {
                v = map.get(key);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()){
            if (map.get(key) == v) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        int count = 0;
        for(Integer i : list){
            res[count++] = i;
        }
        return res;
    }
    private static void dfs(TreeNode root){
        if (root == null) {
            return ;
        }
        if (root.left != null){
            dfs(root.left);
        }
        map.put(root.val,map.getOrDefault(root.val,0) + 1);
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
