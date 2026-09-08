class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int c = b + 1;
                int d = n - 1;
                while (c < d) {
                    long sum = (long) nums[a] + (long) nums[b] + (long) nums[c] + (long) nums[d];
                    System.out.println("SUM "+sum);
                    if (sum == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[a]);
                        tempList.add(nums[b]);
                        tempList.add(nums[c]);
                        tempList.add(nums[d]);
                        result.add(tempList);
                       // System.out.println("Hello "+a+" "+b+" "+c+" "+d);
                        c++;
                        d--;
                        while(c<d && nums[c]==nums[c-1])
                            c++;
                        while(c<d && nums[d]==nums[d+1])
                            d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return result;
    }
}