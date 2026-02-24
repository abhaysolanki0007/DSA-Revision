1class Solution {
2    public int numRescueBoats(int[] people, int limit) {
3        int n=people.length;
4        Arrays.sort(people);
5        int l=0,r=n-1,c=0;
6        while(l<=r){
7           if(people[l]+people[r]<=limit){
8            l++;r--;
9           }
10           else r--;
11           c++;
12        }
13        return c;
14    }
15}