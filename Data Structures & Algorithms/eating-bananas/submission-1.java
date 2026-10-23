class Solution {
    private boolean canEat(int[] piles,int h,int val){
        int count = 0;
        for(int i =0;i<piles.length;i++){
            if(piles[i]<=val){
                count++;
            }else{
                count += piles[i]/val;
                if(piles[i]%val!=0)
                    count++;
            }
            if(count>h)
                return false;
        }
        return count<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        if(h==n)
            return piles[n-1];
        int low = 1;
        int high = piles[n-1];
        int result = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            boolean isPossible = canEat(piles,h,mid);
            //System.out.println("Mid "+mid +" "+isPossible);
            if(isPossible){
                high = mid-1;
                if(result>mid)
                    result = mid;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}
