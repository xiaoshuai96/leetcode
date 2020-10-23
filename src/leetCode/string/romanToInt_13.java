package leetCode.string;
/**
 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000

 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
    所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

 * */
import java.util.HashMap;
import java.util.Map;

public class romanToInt_13 {
    public static void main(String[] args){
        int i = romanToInt03("XXVII");
        System.out.println(i);
    }

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了8.44% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了29.24% 的用户
     * @param s
     * @return
     */
    public static int romanToInt(String s){
        int sum = 0;
        int p = 0;
        while (p < s.length()) {
            //只剩一个字符了
            if ((p + 1) >= s.length()) {
                sum += findNumber(s.charAt(p)+"");
                p++;
            } else {//至少还有两个字符（包括当前字符）
                String tmp = s.charAt(p) + "" + s.charAt(p+1);
                int ans = findNumber(tmp);
                //如果查出来的数字不为0，说明这两个字符组成的是有效的
                if (ans != 0) {
                    sum += ans;
                    p += 2;
                } else {
                    sum += findNumber(s.charAt(p)+"");
                    p++;
                }
            }
        }
        return sum;
    }
    private static int findNumber(String c){
        switch (c){
            case "I" : return 1;
            case "V" : return 5;
            case "X" : return 10;
            case "L" : return 50;
            case "C" : return 100;
            case "D" : return 500;
            case "M" : return 1000;
            case "IV": return 4;
            case "IX": return 9;
            case "XL": return 40;
            case "XC": return 90;
            case "CD": return 400;
            case "CM": return 900;
            default  : return 0;
        }
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了69.02% 的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了98.32% 的用户
     * @param s
     * @return
     */
    public int romanToInt02(String s) {
        int sum = 0;
        //记录当前字符的前一个字符对应的值
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            //如果当前字符对应的值大于前一个字符的值，执行减操作，否则执行加操作
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了49.89% 的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了98.26% 的用户
     * @param s
     * @return
     */
    public static int romanToInt03(String s){
        int res = 0;
        //用单个字符替换所有的双字符
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        for (int i = 0; i < s.length(); i++) {
            res += getVal(s.charAt(i));
        }
        return res;
    }
    private static int getVal(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default: return 0;
        }
    }
}
