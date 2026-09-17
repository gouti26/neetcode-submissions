class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        int j =0;
        for(int i =0;i<n;i++){
            //remove element outside current window
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            //maintain decreasing order
            while(!dq.isEmpty() && nums[dq.getLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);

            if(i>=k-1){
                res[j++] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
