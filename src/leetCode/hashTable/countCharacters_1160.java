package leetCode.hashTable;

import java.util.HashMap;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 *
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *
 *
 *
 * 提示：
 *
 *     1 <= words.length <= 1000
 *     1 <= words[i].length, chars.length <= 100
 *     所有字符串中都仅包含小写英文字母
 *
 */
public class countCharacters_1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        int i = countCharacters(words, chars);
        System.out.println(i);
    }

    /**
     * 执行用时 :12 ms, 在所有 Java 提交中击败了62.26% 的用户
     * 内存消耗 :42.3 MB, 在所有 Java 提交中击败了5.08%的用户
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters01(String[] words, String chars) {
        int[] c = new int[26];
        for(char cc : chars.toCharArray()) {
            c[(int)(cc - 'a')] += 1;
        }
        int res = 0;
        a: for(String word : words) {
            int[] w = new int[26];
            for(char ww : word.toCharArray()) {
                w[(int)(ww - 'a')] += 1;
            }
            for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }



    /**
     * 执行用时 :98 ms, 在所有 Java 提交中击败了11.41% 的用户
     * 内存消耗 :42.6 MB, 在所有 Java 提交中击败了5.08%的用户
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = restoreMap(chars);
        int res = 0,count = 0;
        for (int i = 0; i < words.length; i++) {
            //对单个单词的匹配
            for (int j = 0; j < words[i].length(); j++) {
                Character c = words[i].charAt(j);
                //如果包含，则减少map中该字符的个数（因为一个字符在一个单词的匹配中只能使用一次）
                //如果map中该字符的个数为0，也结束对该单词的匹配
                if (map.containsKey(c) && map.get(c) != 0) {
                    map.put(c,map.get(c)-1);
                    count++;
                    continue;
                }
                //如果map中不包含当前word中的任何一个字符，直接跳过该word
                break;
            }
            res += (count == words[i].length())?count:0;
            count = 0;
            //对每个单词的匹配结束之后，恢复map中的原始数据
            map.clear();
            map = restoreMap(chars);
        }
        return res;
    }
    public static HashMap<Character,Integer> restoreMap(String chars){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i),map.getOrDefault(chars.charAt(i),0)+1);
        }
        return map;
    }
}
