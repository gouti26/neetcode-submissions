class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<asteroids.length;i++){
            int val = asteroids[i];
            
            while(!st.isEmpty() && val<0 && st.peek()>0){
                int diff = val + st.peek();
                if(diff<0){
                    st.pop();
                }else if(diff>0){
                    val = 0;
                }else{
                    val = 0;
                    st.pop();
                }
            }
            if(val!=0)
                st.push(val);
        }
        
        int n = st.size();
        //System.out.println("ST size"+n);
        int[] result = new int[n];
        int i = n-1;
        while(!st.isEmpty()){
            result[i--] = st.pop();
        }
        return result;
    }
}