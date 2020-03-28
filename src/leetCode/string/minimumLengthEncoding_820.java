package leetCode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，
 * 我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，
 * 直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 *
 *
 * 提示：
 *
 *     1 <= words.length <= 2000
 *     1 <= words[i].length <= 7
 *     每个单词都是小写字母 。
 *
 */
public class minimumLengthEncoding_820 {
    public static void main(String[] args) {

    }

    /**
     * 因为题目中限制了每个单词的最长长度，所以我们可以列举出每个单词的所有后缀，对于每个后缀，如果其存在于
     * words列表中，我们就将其删除，最终返回的就是剩余的每个单词+1的总和
     * @param words
     * @return
     */
    public static int minimumLengthEncoding(String[] words) {
        List<String> list = Arrays.asList(words);
        Set<String> set = new HashSet<>(list);
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int res = 0;
        for (String s : set) {
            res += s.length()+1;
        }
        return res;
    }
}
