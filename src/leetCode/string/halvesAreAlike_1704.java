package leetCode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。
 * 注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 *
 * 示例 2：
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 *
 * 示例 3：
 * 输入：s = "MerryChristmas"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "AbCdEfGh"
 * 输出：true
 *
 * 提示：
 *     2 <= s.length <= 1000
 *     s.length 是偶数
 *     s 由 大写和小写 字母组成
 */
public class halvesAreAlike_1704 {
    public static void main(String[] args) {
        String s = "gfLpdQfBhLSNWKBvRWpNlRWTSMQYTSyPFTwWHptvnJHFWQDQLdYyHzKJjYrpHbNQyP" +
                "FWpKhChZXsvYfPBVMpRSfLZwHMBqsbPhZBhwfmjDqgXVkZrtyXbpXWVLRnpGPWjvKNHmx" +
                "qxPSlvxxsxsnbQvKJDwKtWgFDrjsgvTScXYPsMBgkWktkdthwsQdCpddrgksxlZMYDcPy" +
                "vMLqztnYGQbrKcKPWqtjdklXZBvNbZfNdNRmbDGpxybGdzghpSmGvmZGpJlfwTbLhQXZS" +
                "fgSJTNvrQGdWyQgJjngKLXNpkMtFWgpcrYHZHJdgDfmkfplDYjWRmBNyFNzgGbRcGBQXW" +
                "cskPpXPlBkdsVwRMNZCLvkdXwDrlcTTNPPMvjPChWHQPJMPSLSzQLlkQWrmLLnknVdWKr" +
                "YZRymTQTRDbsgtFjZQjMNdrZVqQdBdywVqSWkkHHmbrwnlzXwYCpbfJSxBPdwDjKQFgYPC" +
                "hQWdJTHRVYRDrLtswMnTNQCjZNsqZBpXjZxWKblqZFxtZgHCjYsbqJZFjQJZlFptgMXVDy" +
                "kQpHlmPzxpKnQNtYDJNhHZkMLVCXJjgRGYwCbNGmkqgRkYjzpBMJHRLkbsgXpMkMWCDncm" +
                "GXBxzZsSrGshcYKClqTyZPcGBJthqXjVlJWNYtPgXkFQSxXxGwsvbgPQQZQfllFfQbXMCk" +
                "qXtTxDlSkgBGfVSSfWCwbzgFnLlMKLQgccrQSyxRyqyXvCzCBGdzPhxLnvJMyDhpWXWNFX" +
                "wcwHCCMsccvrxbtsjcThqsLMrgkxlLLGKCbtdHqvBKjxlmntDrvCKxwpMrWZycsvDjCRjP" +
                "XQPZxmvHnxGWpBqkJCkcqfmyRHPSgGxxkHgSLXNsfVxQRwbftyCxvzHrCzXKXfghSwTMpDz" +
                "BhmjXLdxFCfpSggVkTVFPQTJCrCwfyVLNQGSLJKVRKtHCwHMNyclLNHHZTzbLJdtkQRzrPV" +
                "gXSLhJKVZlqYVzPsmwZYPmqKhQC";
        boolean b = new halvesAreAlike_1704().halvesAreAlike(s);
        System.out.println(b);
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了100.00% 的用户
     * @param s
     * @return
     */
    public boolean halvesAreAlike(String s) {
        if (s.length() % 2 != 0) return false;
        int a_count = 0,b_count = 0;
        List<Character> tmp = new ArrayList<>();
        tmp.add('a');
        tmp.add('e');
        tmp.add('i');
        tmp.add('o');
        tmp.add('u');
        tmp.add('A');
        tmp.add('E');
        tmp.add('I');
        tmp.add('O');
        tmp.add('U');
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() / 2) {
                if (tmp.contains(s.charAt(i))) {
                    a_count++;
                }
            } else {
                if (tmp.contains(s.charAt(i))) {
                    b_count++;
                }
            }
        }
        return a_count == b_count;
    }
}
