package leetCode.array;

import java.math.BigInteger;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 *
 * 思路：
 *  这里的加法主要的问题是进位还有输入的数字超出范围，所以我们使用BigInteger类型来存储数据。
 *  1.先将数组中的各个数字连起来组成一个字符串
 *  2.将这个字符串传入BigInteger中，该类会自动将字符串转化成对应的数字，然后进行加1操作
 *  3.将加1之后的结果转换成字符串，然后使用split方法进行分割组成数组
 *  4.创建新的int数组，将上面的String数组中的各个元素转换成int类型存入这个int数组中，并返回。
 */
public class plusOne_66 {
    public static void main(String[] args){
        int[] arr = {8,7,5,6,2,1};
        int[] arr1 = plusOne(arr);
        for (int a : arr1) {
            System.out.print(a+"\t");
        }
    }
    public static int[] plusOne(int[] digits){
        int diglength = digits.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i < diglength;i++) {
            sb.append(digits[i]);
        }
        BigInteger bigInteger = new BigInteger(sb.toString());
        BigInteger bigIntegerPlus = bigInteger.add(new BigInteger("1"));
        String str1 = bigIntegerPlus.toString();
        String str2[] = str1.split("");
        int[] plus = new int[str2.length];
        for (int i = 0; i < str2.length;i++) {
            plus[i] = Integer.parseInt(str2[i]);
        }
        return plus;

    }
}
