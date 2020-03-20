package leetCode.array;
import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class generate_118 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        //numRows为0直接返回triangle，也就是默认空集合
        if (numRows == 0) return triangle;

        //因为杨辉三角的第一行总是1，所以先新建一个list，并将1加入该list中
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        //从第二行开始，新建表示当前行的list，拿到当前行的前一行的list
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            //行中的第一个元素总是1
            row.add(1);

            //针对每一行，都是上一行的相邻的两个元素相加得到两个1中间的数
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            //行中的最后一个元素也总是1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
