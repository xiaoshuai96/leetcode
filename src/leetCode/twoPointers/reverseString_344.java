package leetCode.twoPointers;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class reverseString_344 {
    public static void main(String[] args) {

    }

    /**
     * twoPointers
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.98% 的用户
     * 内存消耗：45.5 MB, 在所有 Java 提交中击败了44.43% 的用户
     * @param s
     */
    public static void reverseString(char[] s){
        if(s.length == 0 || s == null) return ;
        int low = 0 ,high = s.length - 1;
        while(low < high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
