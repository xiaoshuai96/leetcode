package leetCode.string;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * 示例 1：
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 *
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 * 提示：
 *
 * 给出的 address 是一个有效的 IPv4 地址
 */
public class defangIPaddr_1108 {
    public static void main(String[] args) {
        defangIPaddr("1.1.1.1");
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了5.39%的用户
     * @param address
     * @return
     */
    public static String defangIPaddr(String address){
        return address.replace(".", "[.]");
    }
}
