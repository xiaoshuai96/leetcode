package leetCode.string;
import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 *     所有输入均为小写字母。
 *     不考虑答案输出的顺序。
 */
public class groupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = new groupAnagrams_49().groupAnagrams(strs);
        for (List<String> strings : list) {
            for (String s : strings) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：765 ms, 在所有 Java 提交中击败了5.00% 的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了96.37% 的用户
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length < 1) return res;
        boolean[] marked = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (marked[i]) continue;
            LinkedList<String> ans = new LinkedList<>();
            ans.addLast(strs[i]);
            marked[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].length() != strs[j].length() || marked[j]) {
                    continue;
                }
                group(res, strs, i, j, ans,marked);
            }
            res.add(ans);
        }
        return res;
    }
    private void group(List<List<String>> res, String[] strs, int start, int end, LinkedList<String> ans,boolean[] marked) {
        int[] tmp1 = new int[26];
        int[] tmp2 = new int[26];
        for(char c : strs[start].toCharArray()) tmp1[c - 'a']++;
        for(char c : strs[end].toCharArray())   tmp2[c - 'a']++;
        for (int i = 0; i < tmp1.length; i++) {
            if (tmp1[i] != tmp2[i]) return;
        }
        marked[end] = true;
        ans.addLast(strs[end]);
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了95.84% 的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了47.76% 的用户
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams02(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}
