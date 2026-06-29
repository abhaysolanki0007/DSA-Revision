1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int count = 0;
4        for (String s : patterns)
5            if (word.indexOf(s) != -1) count++; // -1 when not found
6        return count;
7    }
8}