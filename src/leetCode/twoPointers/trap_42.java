package leetCode.twoPointers;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class trap_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int i = trap(height);
        System.out.println(i);
    }

    /**
     * 双指针
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.98% 的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了11.78%的用户
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                result += leftMax - height[left] > 0 ?
                        leftMax - height[left] : 0;
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                result += rightMax - height[right] > 0 ?
                        rightMax - height[right] : 0;
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }
    public int trap02(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
