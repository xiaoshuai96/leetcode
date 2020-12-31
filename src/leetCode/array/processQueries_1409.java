package leetCode.array;
import java.util.*;

/**
 * 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。
 * 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
 *     一开始，排列 P=[1,2,3,...,m]。
 *     对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），
 *     然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i]
 *     在 P 中的位置就是 queries[i] 的查询结果。
 * 请你以数组形式返回待查数组  queries 的查询结果。
 *
 *
 *
 * 示例 1：
 * 输入：queries = [3,1,2,1], m = 5
 * 输出：[2,1,2,1]
 * 解释：待查数组 queries 处理如下：
 * 对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，接着我们把 3 移动到 P 的起始位置，得到 P=[3,1,2,4,5] 。
 * 对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,3,2,4,5] 。
 * 对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，接着我们把 2 移动到 P 的起始位置，得到 P=[2,1,3,4,5] 。
 * 对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,2,3,4,5] 。
 * 因此，返回的结果数组为 [2,1,2,1] 。
 *
 * 示例 2：
 * 输入：queries = [4,1,2,2], m = 4
 * 输出：[3,1,2,0]
 *
 * 示例 3：
 * 输入：queries = [7,5,5,8,3], m = 8
 * 输出：[6,5,0,7,5]
 *
 * 提示：
 *     1 <= m <= 10^3
 *     1 <= queries.length <= m
 *     1 <= queries[i] <= m
 */
public class processQueries_1409 {
    public static void main(String[] args) {
        int[] queries = new processQueries_1409().processQueries02(new int[]{7,5,5,8,3,1,2,5,6,8,7,9,4,1,23,56,45}, 45);
        System.out.println(Arrays.toString(queries));
    }

    /**
     * 执行用时：352 ms, 在所有 Java 提交中击败了5.08% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了67.92% 的用户
     * @param queries
     * @param m
     * @return
     */
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        LinkedList<Integer> p = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            p.addLast(i);
        }
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            int tmp = findElement(p,queries[i]);
            res[index++] = tmp;
            Integer head = p.remove(tmp);
            p.addFirst(head);
        }
        return res;
    }
    private int findElement(LinkedList<Integer> p,int target){
        int index = -1;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) == target){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了71.53% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了68.94% 的用户
     * @param queries
     * @param m
     * @return
     */
    public int[] processQueries02(int[] queries, int m) {
        int[] res = new int[queries.length];
        ArrayList<Integer> p = new ArrayList<Integer>();
        for (int i = 1; i <= m; i++) {
            p.add(i);
        }
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            int querie = queries[i];
            for (int j = 0; j < m; j++) {
                //在集合中查找与querie相同的元素，找到之后
                //将元素下标存入目标数组中，然后在集合中移除掉该元素
                //最后将该元素重新添加到集合的头部
                if (p.get(j) == querie) {
                    res[index++] = j;
                    p.remove(j);
                    p.add(0,querie);
                    break;
                }
            }
        }
        return res;
    }
}
