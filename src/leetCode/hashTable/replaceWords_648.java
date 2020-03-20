package leetCode.hashTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 在英语中，我们有一个叫做 词根(root)的概念，
 * 它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。
 * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 示例 1:
 *
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 *
 * 注:
 *
 *     输入只包含小写字母。
 *     1 <= 字典单词数 <=1000
 *     1 <=  句中词语数 <= 1000
 *     1 <= 词根长度 <= 100
 *     1 <= 句中词语长度 <= 1000
 *
 */
public class replaceWords_648 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时 :267 ms, 在所有 Java 提交中击败了8.54% 的用户
     * 内存消耗 :47.1 MB, 在所有 Java 提交中击败了77.22%的用户
     * @param dict
     * @param sentence
     * @return
     */
    public static String replaceWords(List<String> dict,String sentence){
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0,i);
                if (set.contains(prefix)) {
                    break;
                }
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(prefix);
        }
        return sb.toString();
    }
}
