class Solution {
    private int findIndex(int[] ar,int x){
        int left = 0, right = ar.length-1;
        int mid = 0;
        if(x<ar[left])
            return left;
        if(x>ar[right])
            return right;
            
        while(left<=right){
            mid = left+(right-left)/2;
            if(ar[mid]==x || mid == 0)
                break;
            if(ar[mid-1]<x && ar[mid+1]>x)
                break;
            if(ar[mid]<x)
                left = mid+1;
            else
                right = mid-1;
        }
        return mid;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findIndex(arr,x);
        System.out.print("Index "+index);
        
        int left = index, right = index+1;
        List<Integer> res = new ArrayList<>();
        while(k>0 && left>=0 && right <arr.length){
            int leftVal = Math.abs(x-arr[left]);
            int rightVal = Math.abs(x-arr[right]);
            if(leftVal<rightVal){
                res.add(arr[left]);
                left--;
            }else if(leftVal>rightVal){
                res.add(arr[right]);
                right++;
            }else{
                if(left<right){
                    res.add(arr[left]);
                    left--;
                }else{
                    res.add(arr[right]);
                    right++;
                }
            }
            k--;
        }
        if(k>0){
            while(left>0 && k>0){
                k--;
                res.add(arr[left]);
                left--;
            }
            while(right<arr.length && k>0){
                k--;
                res.add(arr[right]);
                right++;
            }
        }
        Collections.sort(res);
        return res;
    }
}