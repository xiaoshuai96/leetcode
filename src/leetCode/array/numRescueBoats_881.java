package leetCode.array;

import java.util.Arrays;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 *
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 *
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 *
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 *
 * 提示：
 *     1 <= people.length <= 50000
 *     1 <= people[i] <= limit <= 30000
 */
public class numRescueBoats_881 {
    public static void main(String[] args) {
        int[] people = {3,5,3,4,1,2,3,5,1,2,1,2,3,4,5,2,1};

        new numRescueBoats_881().numRescueBoats(people,5);
    }

    /**
     * 算法思想：
     * 首先对于数组进行排序之后，元素按照升序排列
     * 我们设置两个指针分别指向数组的头和尾，将头和尾的元素相加与limit进行比较，
     * 1.如果小于等于limit，说明一艘船可以乘坐这两个人
     * 然后我们需要将左右指针各朝前走一步
     * 2.如果大于limit，说明这两个人是不能乘坐同一艘船的，只能是右指针指向的元素一人乘坐（单个元素不会大于limit，题目中已经说明）
     * 单独移动右指针即可
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int i = 0, j = people.length - 1;
        Arrays.sort(people);
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            count++;
        }
        return count;
    }
}
