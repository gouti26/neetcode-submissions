class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));

        res.add(intervals[0]);
        int j = 0;
        for(int i =1;i<intervals.length;i++){
            if(res.get(j)[1]>=intervals[i][0]){
                res.get(j)[1] = Math.max(res.get(j)[1],intervals[i][1]);
            }else{
                res.add(intervals[i]);
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
