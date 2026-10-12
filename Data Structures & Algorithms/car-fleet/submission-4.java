class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==0)
            return 0;
        double[][] pair = new double[n][2];

        for(int i = 0;i<n;i++){
            pair[i][0] = position[i];
            pair[i][1] =  (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(pair,(a,b)->Double.compare(b[0],a[0]));
        int fleets = 1;
        double prevTime = pair[0][1];

        for(int i =1;i<n;i++){
            double currentTime = pair[i][1];
            if(currentTime>prevTime){
                fleets++;
                prevTime = currentTime;
            }
        }
        return fleets;
    }
}
