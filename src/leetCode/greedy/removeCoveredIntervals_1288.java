package leetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 * 示例：
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *
 * 提示：​​​​​​
 *     1 <= intervals.length <= 1000
 *     0 <= intervals[i][0] < intervals[i][1] <= 10^5
 *     对于所有的 i != j：intervals[i] != intervals[j]
 */
public class removeCoveredIntervals_1288 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了90.26% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了81.53% 的用户
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return len;
        //如果左端相等的情况下，右端按照降序排列（例如[2,8]和[2,6]，
        // 如果[2,6]在[2,8]之前出现的话是无法检测到[2,6]被覆盖的）
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0] ;
            }
        });
        int count = 0;
        int currRight = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] <= currRight) {
                count++;
            } else {
                currRight = intervals[i][1];
            }
        }
        return len - count;
    }
}
