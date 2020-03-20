package leetCode.string;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * */
public class lengthOfLastWord_58 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(getLength(s));
    }
    public static int getLength(String s){
        if (s.length()==0) {
            return 0;
        }
        int index = 0;
        int temp = 0;//最后一个单词的字母个数
        int p = s.length()-1;
        //拿到字符串末尾的空格个数，这里要防止字符串越界
        while ((p-index >=0) && s.charAt(p-index) == 32) index++;
        if (p - index < 0)return 0;
        //从最后一个不是空格的字符开始统计
        for (int i = p-index;i >= 0;i--) {
            if (s.charAt(i) != 32){
                temp++;
            }else{
                break;
            }
        }
        return temp;
    }
}
