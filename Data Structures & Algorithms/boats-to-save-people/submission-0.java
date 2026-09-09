class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length-1;
        int totalBoats = 0;
        while(i<=j){
            int peopleWeight = people[i] + people[j];
            if(peopleWeight<=limit){
                i++;
            }
            j--;
            totalBoats++;
        }
        return totalBoats;
    }
}