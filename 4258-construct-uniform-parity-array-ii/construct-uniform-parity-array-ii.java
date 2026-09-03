class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        int oddCount = 0;
        
        for (int num : nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                minOdd = Math.min(minOdd, num);
                oddCount++;
            }
        }
        
        // Already uniform (all even or all odd)
        if (oddCount == 0 || oddCount == nums1.length) {
            return true;
        }
        
        // Can make all odd if we have an odd smaller than all evens
        return minOdd < minEven;
    }
}