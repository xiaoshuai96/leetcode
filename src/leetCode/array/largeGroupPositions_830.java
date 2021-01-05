package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
 * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *
 * 示例 1：
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * 示例 2：
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 *
 * 示例 3：
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 *
 * 示例 4：
 * 输入：s = "aba"
 * 输出：[]
 *
 * 提示：
 *     1 <= s.length <= 1000
 *     s 仅含小写英文字母
 */
public class largeGroupPositions_830 {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> list = new largeGroupPositions_830().largeGroupPositions(s);
        for (List<Integer> integerList : list) {
            for (Integer i : integerList) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了65.30% 的用户
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s.length() < 3) return res;
        int start = 0,end = 1;
        while (end <= s.length()) {
            if (end == s.length()) {
                add(start, end, res);
                return res;
            }
            //相等的话继续往后看
            if (s.charAt(start) == s.charAt(end)) {
                end++;
            } else {//否则判断是不是已经有三个以上的字符了，有，加；否则，重新计算
                add(start,end,res);
                start = end;
            }
        }
        return res;
    }
    //满足至少三个字符相同，就将起始和终止下标加入res中
    private void add(int start,int end,List<List<Integer>> res){
        if (end - start >= 3) {
            res.add(Arrays.asList(start,end - 1));
        }
    }
}
