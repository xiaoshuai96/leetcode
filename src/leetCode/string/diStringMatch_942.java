package leetCode.string;
/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 *     如果 S[i] == "I"，那么 A[i] < A[i+1]
 *     如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 *
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 *
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 *
 * 示例 3：
 *
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 *
 *
 * 提示：
 *
 *     1 <= S.length <= 1000
 *     S 只包含字符 "I" 或 "D"。
 *
 */
import java.util.Arrays;
public class diStringMatch_942 {
    public static void main(String[] args) {
        String S = "DDI";
//        int[] res = diStringMatch(S);
        int[] res = diStringMatch02(S);
        System.out.println(Arrays.toString(res));
    }

    public static int[] diStringMatch01(String S) {
        int[] res = new int[S.length()+1];
        String[] s = S.split("");
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("I")) {
                //判断指定位置的数字是否符合条件
                if (res[i] < res[i + 1]) {
                    continue;
                } else {
                    //否则交换两个数字的位置
                    res[i]   = res[i] ^ res[i+1];
                    res[i+1] = res[i] ^ res[i+1];
                    res[i]   = res[i] ^ res[i+1];
                }
            } else {
                if (res[i] > res[i + 1]) {
                    continue;
                } else {
                    res[i]   = res[i] ^ res[i+1];
                    res[i+1] = res[i] ^ res[i+1];
                    res[i]   = res[i] ^ res[i+1];
                }
            }
        }
        return res;
    }
    //官方代码
    public static int[] diStringMatch02(String S){
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }
        ans[N] = lo;
        return ans;
    }
}
