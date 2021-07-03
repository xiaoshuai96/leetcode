package leetCode.string;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 示例 1:
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class frequencySort_451 {
    public static void main(String[] args) {
        String s = "cccaa";
        new frequencySort_451().frequencySort(s);
    }


    /**
     * 官方题解
     * @param s
     * @return
     */
    public String frequencySort02(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public String frequencySort(String s) {
        Node[] nodes = new Node[128];
        for(char c : s.toCharArray()){
            if (nodes[c] != null) {
                nodes[c].c = c;
                nodes[c].count++;
            } else {
                nodes[c] = new Node(c, 1);
            }
        }
        List<Node> list = new ArrayList<>();
        for (Node node : nodes){
            if (node != null) {
                list.add(node);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (Node node : list) {
            String aChar = generateStringByChar(node.c, node.count, sb);
            res.append(aChar);
        }
        return res.toString();
    }
    //自定义类，c代表该字符，count表示该字符在字符串中出现的次数
    private class Node implements Comparable<Node>{
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }

        public void setC(char c) {
            this.c = c;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - count;
        }
    }
    private String generateStringByChar(char c ,int n,StringBuilder sb){
        sb.delete(0, sb.length());
        if (n <= 0) return "";
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
