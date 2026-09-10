class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        int i = m + n - 1;
        for (; i >= 0 && b >= 0 && a>=0; i--) {
            if (nums1[a] >= nums2[b]) {
                nums1[i] = nums1[a];
                a--;
            } else {
                nums1[i] = nums2[b];
                b--;
            }
        }
        while(a>=0)
            nums1[i--] = nums1[a--];
        while(b>=0)
            nums1[i--] = nums2[b--];
    }
}