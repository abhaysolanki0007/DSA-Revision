1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        int n=words.length;
4        StringBuilder ans=new StringBuilder();
5        // int sum=0;
6        for(int i=0;i<n;i++){
7             int sum=0;
8            String str=words[i];
9            int m=str.length();
10            for(int j=0;j<m;j++){
11                sum+=weights[str.charAt(j)-'a'];
12            }
13            sum=sum%26;
14            sum=25-sum;
15            char ch=(char)('a'+sum);
16            ans.append(ch);
17        }
18        return ans.toString();
19    }
20}