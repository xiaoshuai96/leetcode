package leetCode.math;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
 * 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 *     装满任意一个水壶
 *     清空任意一个水壶
 *     从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 *
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class canMeasureWater_365 {
    public static void main(String[] args) {

    }
    public static boolean canMeasureWater(int x,int y,int z){
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % gcd(x, y) == 0;
    }
    public static int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }
}
