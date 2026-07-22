class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    private void backtrack(int start, int[] nums, List<Integer> list) {
        ans.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            list.add(nums[i]);
            backtrack(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}