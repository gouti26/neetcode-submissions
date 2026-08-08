class Solution {
    private void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    private void helper(int[] nums, int index, List<List<Integer>> res){
        if(index==nums.length){
            List<Integer> tempList = new ArrayList<>();
            for(int num:nums){
                tempList.add(num);
            }
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i =index;i<nums.length;i++){
            swap(nums,i, index);
            helper(nums,index+1,res);
            swap(nums,i, index);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res);
        return res;
    }
}
