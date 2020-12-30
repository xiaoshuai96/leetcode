package leetCode.array;
/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * 提示：
 *     1 <= arr.length <= 100
 *     1 <= arr[i] <= 1000
 */
public class sumOddLengthSubarrays_1588 {
    public static void main(String[] args) {
        int i = new sumOddLengthSubarrays_1588().sumOddLengthSubarrays(new int[]{10,11,12});
        System.out.println(i);
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了51.81% 的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了62.45% 的用户
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            if ((i) % 2 == 1) {
                res += countArrByStep(arr, i);
            }
        }
        return res;
    }

    /**
     * @param arr  source array
     * @param step 步长
     * @return
     */
    private int countArrByStep(int[] arr,int step){
        int len = arr.length;
        int res = 0;
        for (int i = 0; i < len && len - i >= step; i++) {
            int index = i;
            for (int j = 0; j < step ; j++) {
                res += arr[index++];
            }
        }
        return res;
    }

    public int sumOddLengthSubarrays02(int[] arr) {
        int sum = 0;

        //总思路是统计该元素在子序列出现的次数并相乘
        for(int i = 0; i < arr.length; i++){
            int len = arr.length;

            //先统计该数组元素左右两边各有多少种元素取法,包括取0个元素
            //举例数组[1, 2, 3, 4, 5]
            //left是该数组元素左边所能取的数的取法,如果下标i为0,那么数字1左边只有1种取法，
            // 就是取0个元素
            //如果下标i为2，那么3左边可以取0个元素,那么就是本身[3],也可以取1个[2, 3],
            //也可以取2个[1,2,3]，直到左边元素取完,那么就有3种取法，
            //所以取法的规律就是当前的索引 + 1,那么左边的取法就是:
            int left = i + 1;
            //同理右边的取法就是把左边的元素减掉然后加上取0个元素的次数;
            int right = len - (i + 1) + 1;

            //只有左边取奇数个，右边取奇数个或者左边取偶数个右边取偶数个的时候,子序列的个数才能为奇数，
            //所以分别统计左右边取奇数个和偶数个元素的次数
            //举例[1, 2, 3, 4, 5] 当下标为0时，数字1左边只能取0,为偶数个元素,那么右边就只能取偶数个
            //元素为[1],[1,2,3],[1,2,3,4,5]分别为0、2和4个
            //所以下标为0时,1出现的次数为3次,也就是左边取偶数个元素的次数乘右边取偶数个元素的次数,
            //加上左边取奇数个元素的次数为0,乘右边结果就是0次,总次数就是3次
            //总结就是计算该元素在子序列出现的次数,使用排列组合法，然后乘该元素的值即可

            //左边取奇数个元素的次数
            int leftOdd = left / 2;
            //左边取偶数个元素的次数
            int leftEven = (left + 1) / 2 ;

            int rightOdd = right / 2;
            int rightEven = (right + 1) / 2;


            sum += (leftOdd * rightOdd + leftEven * rightEven) * arr[i];

        }
        return sum;
    }
}
