class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char ch:tasks){
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq,freq[ch-'A']);
        }
        Arrays.sort(freq);
        int totalIdleTime = (maxFreq-1)*n;

        for(int i =24;i>=0;i--){
            totalIdleTime -= Math.min(maxFreq-1, freq[i]);
        }

        if(totalIdleTime<0)
            return tasks.length;
        return tasks.length + totalIdleTime;
    }
}
