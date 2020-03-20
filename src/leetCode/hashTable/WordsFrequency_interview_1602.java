package leetCode.hashTable;
import java.util.HashMap;

/**
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 *     WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 *     get(word)查询指定单词在数中出现的频率
 *
 * 示例：
 *
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 *
 * 提示：
 *
 *     book[i]中只包含小写字母
 *     1 <= book.length <= 100000
 *     1 <= book[i].length <= 10
 *     get函数的调用次数不会超过100000
 *
 */
public class WordsFrequency_interview_1602 {
    HashMap<String,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        WordsFrequency_interview_1602 wi = new WordsFrequency_interview_1602(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        int i = wi.get("have");
        System.out.println(i);
    }

    /**
     * 执行用时 :317 ms, 在所有 Java 提交中击败了13.81% 的用户
     * 内存消耗 :86.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param book
     */
    public WordsFrequency_interview_1602(String[] book) {
        for(int i = 0;i < book.length;i++){
            //如果map中存在该key，直接在原有的value上+1，否则使用defaultValue  0
            map.put(book[i], map.getOrDefault(book[i], 0) + 1);
        }
    }
    public int get(String word) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        return 0;
    }
}
