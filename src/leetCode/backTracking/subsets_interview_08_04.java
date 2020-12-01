package leetCode.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class subsets_interview_08_04 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了95.57% 的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了83.99% 的用户
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,new LinkedList<>(),0,res);
        return res;
    }
    private static void backTrack(int[] nums,List<Integer> track,int k,List<List<Integer>> res){
        res.add(new LinkedList(track));
        for(int i = k;i < nums.length;i++){
            track.add(nums[i]);
            backTrack(nums,track,i + 1,res);
            track.remove(track.size() - 1);
        }
    }
}
