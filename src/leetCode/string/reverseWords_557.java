package leetCode.string;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 提示：
 *
 *     在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class reverseWords_557 {
    public static void main(String[] args) {
        String s = reverseWords("Let's take LeetCode contest");
        System.out.println(s);
        System.out.println(s.length());
    }

    /**
     * 执行用时：26 ms, 在所有 Java 提交中击败了16.12% 的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了5.01% 的用户
     */
    static StringBuffer sb = new StringBuffer();
    public static String reverseWords(String s){
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        String[] split = s.split(" ");
        String res = "";
        for (String ss : split) {
            res = res + reverse(ss)+" ";
        }
        return res.substring(0,res.length() - 1);

    }
    private static String reverse(String s){
        sb.delete(0,sb.length());
        StringBuffer append = sb.append(s);
        return append.reverse().toString();
    }

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了41.32% 的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了45.04% 的用户
     * @param s
     * @return
     */
    public String reverseWords02(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            //记录每一个单词的开始和结束位置
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            //倒着将它们插入到ret中
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            //在整个s还没有遍历完的时候，继续添加空格和遍历单词
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
