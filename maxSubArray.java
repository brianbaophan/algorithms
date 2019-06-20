class Solution {
    /*
     * Given an integer array nums, find the contiguous subarray (containing at
     * least one number) which has the largest sum and return its sum.
     * 
     * Kadane's Algorithm (dynamic programming)
     */
    public int maxSubArray(int[] nums) {
        // input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        // runner:       [-2,1,-2,4, 3,5,6, 1,5]    
        // ouptut: 6
        int runningValue = 0;
        int currentValue;
        int maxValue = nums[0]; 
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            /*
             * the running value will always be the known sum in a contiguous 
             * sub-array so far. 
             * 
             * the running value will alawys be the either the largest sum so 
             * far in the previous index plus the current vaue, or the current
             * value (indicating the start of a new sub-array being argued).
             */
            currentValue = nums[i];

            /*
             * in order to save space, notice how a negative element in a contiguous
             * sub-array never leads to the max sum compraed to other sub-arrays.
             * 
             * if the previous running sum is negative, we can assume that the sum for 
             * this sub-array will not be the max sum. 
             */
            if (runningValue >= 0) {
                runningValue += currentValue;
            }

            /*
             * this algorithm compares the running value and the current value. 
             * 
             * the greatest value between the two becomes the new running value,
             * or the largest sum known so far in the sub-array.
             */
            else {
                if (currentValue >= runningValue) {
                    runningValue = currentValue;
                }
            }

            if (runningValue > maxValue) {
                maxValue = runningValue;
            }
        }

        return maxValue;
    }
}
