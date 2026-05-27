1class Solution {
2    public int numberOfSpecialChars(String word) {
3         int n=word.length();
4        int arr1[]=new int[26];
5        int arr2[]=new int[26];
6         int ans[]=new int[26];
7         int res=0;
8         Arrays.fill(ans,-1);
9        for(int i=0;i<n;i++){
10            char ch=word.charAt(i);
11            if(Character.isUpperCase(ch)){
12                if(arr2[ch-65]>0){
13                   if(ans[ch-65]==-1) ans[ch-65]=1;
14                }
15                arr1[ch-65]++;
16            }
17            else{
18                 arr2[ch-97]++;
19                 if(arr1[ch-97]>0){
20                    ans[ch-97]=0;
21                 }
22            }
23        }
24        for(int i=0;i<26;i++){
25           if(ans[i]>0) res+=ans[i];
26        }
27        return res;
28
29    }
30}