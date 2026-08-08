class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        if(prerequisites.length == 0)
            return true;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for(int[]pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> Q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i]==0)
                Q.add(i);
        }
        int completedCourses = 0;
        while(!Q.isEmpty()){
            int curr = Q.poll();
            for(int course:graph.get(curr)){
                indegree[course]--;
                if(indegree[course]==0){
                    Q.offer(course);
                }
            }
            completedCourses++;
        }
        return completedCourses == n;
    }
}
