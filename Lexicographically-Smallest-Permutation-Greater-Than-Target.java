1class Solution {
2    public String remsorted(int freq[]){
3        StringBuilder res=new StringBuilder();
4        for(int i=0;i<26;i++){
5            char ch=(char)('a'+i);
6            while(freq[i]>0){
7               res.append(ch);freq[i]--;
8            }
9        }
10        return res.toString();
11    }
12    public String lexGreaterPermutation(String s, String target) {
13        int freq2[]=new int[26];
14        int n=s.length();
15        for(int i=0;i<n;i++){
16            char ch=s.charAt(i);
17            freq2[ch-'a']++;
18        }
19        int freq[]=freq2.clone();
20        StringBuilder sb=new StringBuilder();
21        int i=0,ind=-1;
22        while(i<n){
23            char ch=target.charAt(i);
24                for(int j=ch-'a'+1;j<26;j++){
25                    if(freq[j]>0){
26                        ind=i;break;
27                        }
28                }
29           if( freq[ch-'a']==0) break;
30           freq[ch-'a']--;
31            i++;
32        }
33        if(ind==-1) return "";
34        System.out.println(ind);
35        for(i=0;i<ind;i++){
36               char ch=target.charAt(i);
37               freq2[ch-'a']--;
38               sb.append(ch);
39        }
40        char ch=target.charAt(i);
41         for(int j=ch-'a'+1;j<26;j++){
42                    if(freq2[j]>0){
43                        freq2[j]--;
44                      sb.append((char)('a'+j));
45                      break;
46                        }
47                
48        }
49        sb.append(remsorted(freq2));
50        return sb.toString();
51    }
52}