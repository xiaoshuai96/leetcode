package leetCode.string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 *
 * 注意:
 *
 *     S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class reorganizeString_767 {
    public static void main(String[] args) {
        String s = reorganizeString("baaba");
        System.out.println(s);
    }
    public static String reorganizeString(String S) {
        int count = 0;
        char max = '/';
        int[] ans = new int[26];
        for (char c : S.toCharArray()) ans[c - 'a']++;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > count) {
                count = ans[i];
                max = (char)(i + 'a');
            }
        }
        char[] temp = new char[S.length()];
        int index = 0;
        for (; index < temp.length; index += 2) {
            if (count != 0) {
                temp[index] = max;
                count--;
            } else break;
        }
        if (count != 0) {
            return "";
        }
        int k = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ans.length; i++) {
            if (i == (max - 'a') || ans[i] == 0) continue;
            if (index < temp.length) {
                temp[index] = (char) (i + 'a');
                index += 2;
            } else {
                temp[k] = (char) (i + 'a');
                k += 2;
            }
            ans[i]--;
        }
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
        }
        return sb.toString();

    }


    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了48.41% 的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了96.17% 的用户
     * @param S
     * @return
     */
    public String reorganizeString02(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
