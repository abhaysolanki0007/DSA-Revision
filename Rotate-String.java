1class Solution {
2    public boolean rotateString(String s, String goal) {
3        if(goal.length()!=s.length()) return false;
4        String s1=goal+goal;
5        if(s1.contains(s)) return true;
6        return false;
7        
8        
9    }
10}