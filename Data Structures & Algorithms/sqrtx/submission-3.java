class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        if(x<=3)
            return 1;
        long high = x / 2;
        long low = 0;
        long result = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            //System.out.println("Mid "+mid);
            if (mid * mid == x) {
                result = mid;
                break;
            }
            if (mid * mid < x && mid > result) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)result;
    }
}