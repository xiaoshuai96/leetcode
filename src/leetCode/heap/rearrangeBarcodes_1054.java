package leetCode.heap;

import javax.jnlp.IntegrationService;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * 在一个仓库里，有一排条形码，其中第i个条形码为 barcodes[i]。
 * 请你重新排列这些条形码，使其中两个相邻的条形码不能相等。
 * 你可以返回任何满足该要求的答案，此题保证存在答案。
 *
 * 示例 1：
 *
 * 输入：[1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 *
 * 示例 2：
 *
 * 输入：[1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 *
 * 提示：
 *
 *     1 <= barcodes.length <= 10000
 *     1 <= barcodes[i] <= 10000
 *
 */
public class rearrangeBarcodes_1054 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,3};
        int[] barcodes = demo(arr);
        System.out.println(Arrays.toString(barcodes));
    }
    public static int[] rearrangeBarcodes(int[] barcodes){
        int[] address = new int[10001];
        for (int barcode : barcodes)
            address[barcode]++;
        // 找到出现次数最多的barcode
        int maxCode = 0, maxCount = 0;
        for (int i = 0; i < address.length; i++) {
            if (maxCount < address[i]) {
                maxCode = i;
                maxCount = address[i];
            }
        }
        int index = 0;
        // 先填充最大的那一位barcode
        for (; address[maxCode] > 0; index += 2) {
            barcodes[index] = maxCode;
            address[maxCode]--;
        }
        // 继续填充剩余的条形码
        for (int i = 1; i < address.length; i++) {
            while (address[i] > 0) {
                //偶数位填充完毕
                if (index >= barcodes.length) index = 1;
                barcodes[index] = i;
                address[i]--;
                index += 2;
            }
        }
        return barcodes;
    }

//重(chong)敲
    public static int[] demo(int[] barcodes) {
        int[] address = new int[10001];
        for (int barcode : barcodes) address[barcode]++;
        //find max count
        int maxCode = 0,maxCount = 0;
        for (int i = 0; i < address.length; i++) {
            if (maxCount < address[i]) {
                maxCount = address[i];
                maxCode = i;
            }
        }
        //将maxCode填充进目标数组的偶数位
        int index = 0;
        for (;index < barcodes.length;index += 2) {
            barcodes[index] = maxCode;
            address[maxCode]--;
        }
        //将剩余的barcode填充进目标数组中
        for (int i = 0;i < address.length;i++) {
            while (address[i] > 0) {
                //说明偶数位已经没有位置了
                if (index >= barcodes.length) index = 1;
                barcodes[index] = i;
                address[i]--;
                index+=2;
            }
        }
        return barcodes;
    }
}
