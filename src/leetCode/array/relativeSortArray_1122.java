package leetCode.array;

import java.util.Arrays;

/**
 * 给你两个数组，arr1 和 arr2，
 *     arr2 中的元素各不相同
 *     arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 提示：
 *     arr1.length, arr2.length <= 1000
 *     0 <= arr1[i], arr2[i] <= 1000
 *     arr2 中的元素 arr2[i] 各不相同
 *     arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class relativeSortArray_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] relativeSortArray = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(relativeSortArray));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了43.28% 的用户
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1,int[] arr2){
        int len1 = arr1.length;
        int[] res = new int[len1];
        //记录每个数字出现的次数，在后面的遍历中相当于直接排序了
        int[] map = new int[1001];
        for(int i = 0;i < arr1.length;i++) map[arr1[i]]++;
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = map[arr2[i]];
            while(count != 0){
                res[index++] = arr2[i];
                count--;
            }
            map[arr2[i]] = 0;
        }
        for (int i = 0; i < map.length; i++) {
            //index一到res边界直接返回
            if (index == res.length)return res;
            while (map[i] != 0) {
                res[index++] = i;
                map[i]--;
            }
        }
        return res;
    }
}
