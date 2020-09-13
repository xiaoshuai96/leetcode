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
        //如果数组的大小和当前list的大小相同，则表示现在list中已经存在了一种全排列的可能
        //直接加到res中，并返回
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


    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了82.94% 的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了83.69% 的用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permute02(int[] nums) {
        if(nums.length == 0 || nums == null){
            return res;
        }
        trackBack(nums,new ArrayList<Integer>());
        return res;
    }
    private void trackBack(int[] nums,List<Integer> list){
        if(nums.length == list.size()){
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i = 0;i < nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            trackBack(nums,list);
            list.remove(list.size() - 1);
        }
    }
}
