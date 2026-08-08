class Solution {
    public int reverse(int x) {
        int sign = 1;
        if(x<0){
            sign = -1;
            x = x*sign;
        }
        int revNum = 0;
        while(x>0){
            int reminder = x%10;
            x = x/10;
            if(revNum >= Integer.MAX_VALUE/10 || revNum<=Integer.MIN_VALUE/10)
                return 0;
            revNum = revNum*10 + reminder;
        }
        return revNum*sign;
    }
}
