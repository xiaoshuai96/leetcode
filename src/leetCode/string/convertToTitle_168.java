package leetCode.string;
/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 *
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 *
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 *
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *
 * 提示：
 *     1 <= columnNumber <= 2^31 - 1
 */
public class convertToTitle_168 {
    public static void main(String[] args) {
        //FXSHRXW
        String s = new convertToTitle_168().convertToTitle(2147483647);
        System.out.println(s);
    }
    public String convertToTitle(int n) {
        if(n <= 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        while(n > 0){
            n--;
            res.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return res.reverse().toString();

    }
}
