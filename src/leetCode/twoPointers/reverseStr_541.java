package leetCode.twoPointers;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *     如果剩余字符少于 k 个，则将剩余字符全部反转。
 *     如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 提示：
 *     1 <= s.length <= 10^4
 *     s 仅由小写英文组成
 *     1 <= k <= 10^4
 */
public class reverseStr_541 {
    public static void main(String[] args) {
        int k = 9;
        //correct:    "dcba efgk / gfhj bkaj / afrh lkih / lnrf akjn / alkf sjfn"

        //incorrect:  "dcba efgk   gfhj bkaj   lnrf hikl   afrh akjn   fkla sjfn"

        //source:     "abcd efgk jhfg  bkaj  hrfa  lkih  frnl  akjn  fkla  sjfn"
        //             0  3 4  7 8  11 12 15 16 19 20 23 24 27 28 31 32 35 36 39
        String s = "abcdefgkjhfgbkakjusdgaksjdhbaskjdnajhrfalkihfrnlakjnfklasjfn";
        new reverseStr_541().reverseStr(s,k);
    }
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0,right = 2 * k - 1;
        //截止条件：剩余字符小于k个
        while(n - left >= k){
            reverse(chars,left,right - k);
            left = left + 2 * k;
            right = right + 2 * k;
        }
        reverse(chars, left, n - 1);
        return new String(chars);
    }
    //反转
    private void reverse(char[] chars,int l,int r){
        if(l >= chars.length) return;
        while(l < r){
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }
}
