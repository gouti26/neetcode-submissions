class Solution {
    class pointInfo{
        int x;
        int y;
        double distance;
        public pointInfo(int x, int y, double distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pointInfo> pq = new PriorityQueue<>(
            (a,b)->Double.compare(a.distance,b.distance));
        
        for(int[] point:points){
            double distance = Math.sqrt((point[0]*point[0]) + (point[1]*point[1]));
            pq.offer(new pointInfo(point[0],point[1],distance));
        }

        int [][] res = new int[k][2];
        for(int i =0;i<k;i++){
            pointInfo curr = pq.poll();
            res[i][0] = curr.x;
            res[i][1] = curr.y;
        }

        return res;

    }
}
