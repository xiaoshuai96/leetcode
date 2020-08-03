package leetCode.string;

import sun.awt.geom.AreaOp;

public class addStrings_415 {
    public static void main(String[] args) {
        String s = addStrings("6913259244", "71103343");
        System.out.println(s);
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了18.44% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了76.05% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public static String addStrings(String nums1,String nums2){
        if (nums1.length() < nums2.length()) {
            return addStrings(nums2,nums1);
        }
        int p1 = nums1.length()-1,p2 = nums2.length()-1,carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0) {
            int c = 0;
            char a = nums1.charAt(p1), b;
            if (p2 < 0) {
                b = '0';
            } else {
                b = nums2.charAt(p2);
            }
            c = a + b - 96 + carry;
            if (c > 9) {
                carry = 1;
                c -= 10;
            } else {
                carry = 0;
            }
            sb.append(c);
            p1--;
            p2--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    /**
     * 官方解法
     * 执行用时：3 ms, 在所有 Java 提交中击败了79.86% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了71.85% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public String addStrings02(String nums1,String nums2){
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = nums1.length() - 1, j = nums2.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i >= 0) carry += nums1.charAt(i--) - '0';
            if(j >= 0) carry += nums2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
