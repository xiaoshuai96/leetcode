package leetCode.string;
/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class oneEditAway_interview_0105 {
    public static void main(String[] args) {
        String first = "  ",second = "r";
        boolean b = new oneEditAway_interview_0105().oneEditAway(first, second);
        System.out.println(b);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.19% 的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了79.88% 的用户
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int len = first.length() - second.length();
        //如果两个字符串之差在[0,1]之间（整数），继续验证，否则返回false
        if (len > 1 || len < -1) {
            return false;
        }
        int count = 1;//编辑的次数
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                if (len == 1) { //second要不要添加一个字符
                    j--;
                } else if (len == -1) { //second要不要删除一个字符
                    i--;
                }
                count--;
            }
            if (count < 0) {//最多编辑一次
                return false;
            }
        }
        return true;
    }
}
