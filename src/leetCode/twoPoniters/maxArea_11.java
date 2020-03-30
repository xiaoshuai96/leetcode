package leetCode.twoPoniters;

import java.time.format.ResolverStyle;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class maxArea_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea02(height);
        System.out.println(i);
    }

    /**
     * 执行用时 :499 ms, 在所有 Java 提交中击败了11.92% 的用户
     * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了7.47%的用户
     *
     * 很明显，这样操作的话时间复杂度就达到了O(n^2)
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length-1;j > i;j--){
                res = Math.max(res,(j-i)*Math.min(height[i],height[j]));
            }
        }
        return res;
    }

    /**
     * 双指针：要使得面积最大化，我们需要考虑的是最长的两条线段之间的面积
     * 最开始，分别使用两个指针（resource，last）指向数组的第一位元素和最后一位元素，
     * 接着判断他们之间的大小，
     * 1.如果resource指向的元素大于last指向的元素，将last前移
     * 2.反之将resource后移
     * 两种操作都求出他们之间的面积，每次与前一个求取的面积比较并取最大值，循环结束之后，res中的值就是最大面积
     *
     * 执行用时 :4 ms, 在所有 Java 提交中击败了75.29% 的用户
     * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了23.23%的用户
     * @param height
     * @return
     */
    public static int maxArea02(int[] height){
        int resource = 0;
        int last = height.length - 1;
        int res = 0;
        while (resource < last) {
            if (height[resource] >= height[last]) {
                res = Math.max(res, (last - resource) * height[last]);
                last--;
            } else {
                res = Math.max(res, (last - resource) * height[resource]);
                resource++;
            }
        }
        return res;
    }
}
