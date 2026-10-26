class Solution {
    public boolean isPalindrome(String str) {
        String s = str.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        for(int i  = 0, j = s.length()-1 ; i < j ; i++, j-- ){
            if(s.charAt(i) == (s.charAt(j)))
                continue;
            else
                return false;
        }
        return true;
    }
}