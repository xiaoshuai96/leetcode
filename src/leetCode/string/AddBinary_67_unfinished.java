package leetCode.string;
/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

     输入为非空字符串且只包含数字 1 和 0。

     示例 1:

     输入: a = "11", b = "1"
     输出: "100"

     示例 2:

     输入: a = "1010", b = "1011"
     输出: "10101"

 */
public class AddBinary_67_unfinished {
    public static void main(String[] args) {
        String s = addBinary("0","0");
        System.out.println(s);
    }
    public static String addBinary(String a,String b){
        int temp1 = 0;
        int temp2 = 0;
        int add = 0;
        StringBuffer sb = new StringBuffer();
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        for (int i = 0;i < c1.length;i++) {
            temp1 += Integer.parseInt(String.valueOf(c1[i]))*Math.pow(2,c1.length-1-i);
        }
        for (int j = 0;j < c2.length;j++) {
            temp2 += Integer.parseInt(String.valueOf(c2[j]))*Math.pow(2,c2.length-1-j);
        }
        add = temp1 + temp2;
        if (add==0) {
            return "0";
        }
        while (add >= 1) {
            sb.append(add%2+"");
            add/=2;
        }
        return sb.reverse().toString();
    }
}
