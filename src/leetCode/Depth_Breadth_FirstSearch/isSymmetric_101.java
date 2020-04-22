package leetCode.Depth_Breadth_FirstSearch;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 思路：如果一棵树的左子树和右子树镜像对称，那么这个树是对称的。
 *  该问题可以转化为：两个树在什么情况时互为镜像？
 *  答：如果满足下面两个条件，就称为镜像
 *      1.他们的根结点具有相同的值
 *      2.每个树的右子树都与另一个树的左子树镜像对称
 *
 *
 * 复杂度分析
 *
 *     时间复杂度：O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)，
 *      其中 nnn 是树中结点的总数。
 *     空间复杂度：递归调用的次数受树的高度限制。在最糟糕情况下，树是线性的，其高度为 O(n)。
 *      因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)。
 *
 */
public class isSymmetric_101 {
    public static void main(String[] args) {

    }
    //判断两个数是否互为镜像
    public static boolean isMirror(Node t1,Node t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.value == t2.value)
                && isMirror(t1.left,t2.right)
                && isMirror(t1.right,t2.left);
    }
}
class Node{
    int value;
    Node left;
    Node right;
}
