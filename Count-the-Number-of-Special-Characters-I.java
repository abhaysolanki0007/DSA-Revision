1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int n=word.length();
4        int arr1[]=new int[26];
5        int arr2[]=new int[26];
6        for(int i=0;i<n;i++){
7            char ch=word.charAt(i);
8            if(Character.isUpperCase(ch)){
9                arr1[ch-65]++;
10            }
11            else{
12                 arr2[ch-97]++;
13            }
14        }
15        int ans=0;
16        for(int i=0;i<26;i++){
17            if(arr1[i]>0&&arr2[i]>0){
18                ans++;
19            }
20        }
21        return ans;
22
23    }
24}