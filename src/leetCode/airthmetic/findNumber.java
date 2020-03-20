package leetCode.airthmetic;

/***
 * 题目：给一组整型数据，这些数据中，其中一个数字只出现了一次，其他的数都出现了两次，请找出这个出现了一次的数、
 * 下面的解决方法：使用位运算，两个相同的数异或的结果是0，一个数和0异或的结果是它本身
 * 例如：4,2,1,2,5,3,1,4,3
 * 如何在这列数据中找出只出现了一次的5呢？
 * 由于异或支持交换律和结合律，那么
 * 4^2^1^2^5^3^1^4^3 = (1^1)^(2^2)^(3^3)^(4^4)^5 = 0^5 = 5
 *
 */
public class findNumber {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,5,4,3,2};
        int a = find(arr);
        System.out.println(a);
    }

    public static int find(int[] arr){
        int tmp = arr[0];
        for (int i = 1;i < arr.length;i++) {
            tmp = tmp ^ arr[i];
        }
        return tmp;
    }
}
