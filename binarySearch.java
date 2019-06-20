class Solution {
    /*
     * Given a sorted (in ascending order) integer array nums of n elements 
     * and a target value, write a function to search target in nums. If 
     * target exists, then return its index, otherwise return -1.
     * 
     * iterative method
     */
    public int search(int[] nums, int target) {
        int size = nums.length;
        int minRange = 0;
        int maxRange = size - 1;
        int currentValue;
        int index;

        /*
         * When minRange's position surpasses maxRange's position, we know 
         * that the target is not in the sorted array. 
         * 
         * minRange will always be on the left side of the current value 
         * and maxrange will always be on the right side of the current value.
         */
        while (minRange <= maxRange) {
            index = (minRange + maxRange)/2;
            currentValue = nums[index];

            if (currentValue == target) {
                return index;
            }

            /*
             * current value is defined to be the mid value between minRange
             * and maxRange. 
             * 
             * when target is not yet found, figure out which sub-array the 
             * target is (front half or back half). 
             * 
             * the front sub-array is located before the current value. 
             * the back sub-array is located after the current value.
             * 
             * After figuring out where the target might be, move minRange or
             * maxRange accordingly. 
             * 
             * example: when target is before the current value, move maxRange to 
             * right before current value. The new range would be from the original
             * minRange to the right before the current value. This range becomes the
             * new front sub-array to continue the search since we know that the target
             * will never be in the back sub-array. 
             */
            else {
                if (target < currentValue) {
                    maxRange = index - 1;
                } else if (target > currentValue) {
                    minRange = index + 1;
                }
            }

        }

        return -1;
    }
}