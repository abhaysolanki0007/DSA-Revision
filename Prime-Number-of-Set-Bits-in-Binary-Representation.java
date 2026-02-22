1class Solution {
2    public boolean isprime(int a){
3        int b=a/2;
4        while(b>1){
5            if(a%b==0) return false;
6            b--;
7        }
8        return true;
9    }
10    public int countPrimeSetBits(int left, int right) {
11        int ans=0;
12        Set<Integer>set=new HashSet<>();
13        for(int i=2;i<30;i++){
14            if(isprime(i)){
15                set.add(i);
16            }
17        }
18        for(int i=left;i<=right;i++){
19            if(set.contains(Integer.bitCount(i))){
20                ans++;
21            }
22        }
23        return ans;
24    }
25}