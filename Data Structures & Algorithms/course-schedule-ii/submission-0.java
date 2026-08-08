class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int[]inDegree = new int[n];
        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(inDegree[i]==0)
                Q.offer(i);
        }

        List<Integer> tempList = new ArrayList<>();
        int completedCourse = 0;
        while(!Q.isEmpty()){
            int curr = Q.poll();
            tempList.add(curr);
            completedCourse++;
            for(int course:graph.get(curr)){
                inDegree[course]--;
                if(inDegree[course]==0){
                    Q.offer(course);
                }
            }
        }

        if(completedCourse==n){
            int[] courseOrder = new int[n];
            int index = 0;
            for(int course:tempList){
                courseOrder[index++] = course;
            }
            return courseOrder;
        }
        return new int[0];

    }
}
