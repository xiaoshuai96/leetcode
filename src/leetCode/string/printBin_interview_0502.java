package leetCode.string;
/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *  输入：0.625
 *  输出："0.101"
 *
 * 示例2:
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 *
 * 提示：
 *     32位包括输出中的"0."这两位。
 */
public class printBin_interview_0502 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.6 MB, 在所有 Java 提交中击败了83.51% 的用户
     * @param num
     * @return
     */
    public String printBin(double num) {
        if(num <= 0 || num >= 1){
            return "ERROR";
        }
        //不是 5 结尾的不能准确转换
        // String temp = String.valueOf(num);
        // if(temp.charAt(temp.length() - 1) != '5'){
        //     return "ERROR";
        // }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while(num != 0){
            num *= 2;
            sb.append(num - 1 >= 0 ? 1 : 0);
            if(num >= 1){
                num --;
            }
            if(sb.length() > 32){
                return "ERROR";
            }
        }
        return sb.toString();
    }
}
