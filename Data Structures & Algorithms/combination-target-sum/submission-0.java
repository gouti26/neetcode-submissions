class Solution {
    List<List<Integer>> result;
    private void helper(int[] ar, int index, List<Integer> tempList, int target){
        if(target==0){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=index;i<ar.length;i++){
            if(ar[i]>target)
                return;
            tempList.add(ar[i]);
            helper(ar,i,tempList,target-ar[i]);
            tempList.remove(tempList.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>(),target);
        return result;
    }
}
