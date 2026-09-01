class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int firstCandidate = -1;
        int count1 = 0;
        int secondCandidate = -1;
        int count2 = 0;
        for(int i = 0;i<n;i++){
            if(nums[i]==firstCandidate){
                count1++;
            }else if(nums[i]==secondCandidate){
                count2++;
            }else if(count1==0){
                count1 = 1;
                firstCandidate = nums[i];
            }else if(count2 == 0){
                count2 = 1;
                secondCandidate = nums[i];
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2=0;
        for(int i=0;i<n;i++){
            if(firstCandidate == nums[i])
                count1++;
            else if(secondCandidate == nums[i])
                count2++;
        }
        List<Integer> result = new ArrayList<>();
        if(count1>n/3)
            result.add(firstCandidate);
        if(count2>n/3)
            result.add(secondCandidate);
        return result;
    }
}