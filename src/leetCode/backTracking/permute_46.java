package leetCode.backTracking;
import sun.awt.SunHints;

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
        List<List<Integer>> permute = permute(new int[]{1,2,3});
        for (List<Integer> list : permute) {
            for (Integer i : list) {
                System.out.print("\t"+i);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,res,new LinkedList<>());
        return res;
    }
    private static void backTrack(int[] nums,List<List<Integer>> res, LinkedList<Integer> track){
        //如果当前集合的size等于数组的长度，说明现在已经拿到了一种组合，添加到res结果集中
        if (nums.length == track.size()) {
            res.add(new ArrayList<>(track));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            //选择
            track.addLast(nums[i]);
            //递归
            backTrack(nums, res, track);
            //撤销选择
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
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return res;
        }
        trackBack(nums,res,new ArrayList<Integer>());
        return res;
    }
    private void trackBack(int[] nums,List<List<Integer>> res,List<Integer> list){
        if(nums.length == list.size()){
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i = 0;i < nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            trackBack(nums,res,list);
            list.remove(list.size() - 1);
        }
    }
}
