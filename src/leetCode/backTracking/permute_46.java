package leetCode.backTracking;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class permute_46 {
    public static void main(String[] args) {

    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track);
        return res;
    }

    /**
     * 回溯算法
     * @param nums
     * @param track
     */
    private static void backTrack(int[] nums, LinkedList<Integer> track){
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums,track);
            track.removeLast();
        }
    }
}
