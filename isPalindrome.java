class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int head = 0; 
        int tail = s.length() - 1;
        
        while (head < tail) {
            
            if (s.charAt(head) != s.charAt(tail)) 
                return false;
            
            head++;
            tail--;
            
        }
        
        return true; 
        
    }
    
}