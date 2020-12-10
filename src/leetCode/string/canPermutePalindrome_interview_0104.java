package leetCode.string;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class canPermutePalindrome_interview_0104 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了51.15% 的用户
     *
     * 算法思路：统计每个字符出现的次数，如果出现的次数是偶次，说明一定可以组成回文字符
     * 如果出现奇数的次数大于1次，说明这个字符串是无法组成回文串的
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 0)return false;
        int odd = 0;
        int[] marked = new int[128];
        for(char c : s.toCharArray()){
            ++marked[c];
        }
        for (int i : marked) {
            if (odd > 1) {
                return false;
            }
            if (i != 0 && i % 2 == 1) {
                ++odd;
            }
        }
        return true;
    }
}
