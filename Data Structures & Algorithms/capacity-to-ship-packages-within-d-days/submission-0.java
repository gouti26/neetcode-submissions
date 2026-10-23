class Solution {
    private boolean canShip(int[] wts, int val, int days){
        int count = 0;
        int n = wts.length;
        int i = 0;
        while(i<n){
            int sum = 0;
            count++;
            while(i<n && sum<=val){
                if(sum+wts[i]<=val){
                    sum +=wts[i];
                    i++;
                }else{
                    break;
                }
            }
            if(count>days)
                return false;
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int high = 0;
        for(int wt:weights)
            high += wt;
        
        int result = 0;
        int low = 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            boolean isPossible = canShip(weights,mid,days);
            //System.out.println("Mid "+mid+" "+isPossible);
            if(isPossible){
                high = mid-1;
                result = mid;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}