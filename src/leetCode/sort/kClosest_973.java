package leetCode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * 提示：
 *     1 <= K <= points.length <= 10000
 *     -10000 < points[i][0] < 10000
 *     -10000 < points[i][1] < 10000
 */
public class kClosest_973 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};
        int[][] kClosest = kClosest03(points, 2);
        for (int[] ints : kClosest) {
            System.out.println(ints[0] + "---" +ints[1]);
        }
    }

    /**
     * 执行用时：270 ms, 在所有 Java 提交中击败了5.10% 的用户
     * 内存消耗：47.6 MB, 在所有 Java 提交中击败了26.18% 的用户
     * piece of shit-
     * @param points
     * @param K
     * @return
     */
    public static int[][] kClosest(int[][] points, int K) {
        int row = points.length;
        int[][] res = new int[K][2];
        double[] arr = new double[row];
        for (int i = 0; i < row; i++) {
            arr[i] = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
        }
        double[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        for (int i = 0; i < K; i++) {
            for(int j = 0;j < arr.length;j++){
                if (temp[i] == arr[j]) {
                    res[i][0] = points[j][0];
                    res[i][1] = points[j][1];
                    arr[j] = Double.MAX_VALUE;//mark
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 自定义排序规则
     * 执行用时：28 ms, 在所有 Java 提交中击败了65.31% 的用户
     * 内存消耗：46.8 MB, 在所有 Java 提交中击败了87.04% 的用户
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest02(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了94.66% 的用户
     * 内存消耗：47.1 MB, 在所有 Java 提交中击败了61.92% 的用户
     */
    static Random rand = new Random();
    public static int[][] kClosest03(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }

    public static void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
