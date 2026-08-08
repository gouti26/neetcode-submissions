class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int totalGas = 0;
        for(int i =0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas<totalCost)
            return -1;
        int startIndex = 0;
        totalGas = 0;
        for(int i =0;i<gas.length;i++){
            totalGas += gas[i];
            totalGas -=cost[i];
            if(totalGas<0){
                totalGas = 0;
                startIndex = i+1;
            }
        }
        return startIndex;
    }
}
