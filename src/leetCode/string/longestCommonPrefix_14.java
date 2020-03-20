package leetCode.string;
/**
     编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"

     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
 * */
public class longestCommonPrefix_14 {
    public static void main(String[] args){
        String[] strs = {"abc","ab","abcoio"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs){
        if(strs==null || strs.length==0)return "";
        for(int i = 0;i < strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (int j = 1;j < strs.length;j++) {
                //防止数组下标越界i==strs[j].length()，strs[0]不一定是最短的字符串
                if(i==strs[j].length() || strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    public static String test(String s){
        String s1 = s.substring(2);//返回字符串的0~2
        String s2 = s.substring(0,3);//返回字符串的0~2
        return s2;


    }
}
