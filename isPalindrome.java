class Solution {
    /*
     * Given a string, determine if it is a palindrome, considering only
     * alphanumeric characters and ignoring cases.
     */
    public boolean isPalindrome(String s) {
        // input: s = "A man, a plan, a canal: Panama"
        // output: true
        int left = 0; 
        int right = s.length() - 1;
        
        /*
         * the left index must always be before the right index
         * 
         * when the left index passes the right index, that means that we have
         * iterated through the whole stirng without finding the left character or
         * right character being unequal
         * 
         * when the loop completes, it is concluded that the given string is a palindrome
         */
        while (left < right) {
            
            /*
             * the two loops below find the first alphanumerical character in the string
             * for the left and right index
             */
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            /*
             * if the character at the left and right indexes do not match, we know that
             * the given string is not a palindrome
             */
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true; 
    }
}
