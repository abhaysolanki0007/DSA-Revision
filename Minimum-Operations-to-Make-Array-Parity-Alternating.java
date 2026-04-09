1class Solution {
2    public boolean allequal(int nums[]){
3        int st=nums[0];
4        for(int a:nums){
5            if(a!=st) return false;
6        }
7        return true;
8    }
9    public int maxi=(int)(1e9);
10    public int[] makeParityAlternating(int[] nums) {
11        int parity=0,n=nums.length;
12        if(n==1) return new int[]{0,0};
13        if(allequal(nums)) return new int[]{
14            n/2,1};
15        int max=-maxi,min=maxi,res1=n+1,res=maxi;
16        List<Integer>list=new ArrayList<>();
17        for(int i=0;i<n;i++){
18            int cur=nums[i];
19            if((Math.abs(nums[i])%2)!=parity) list.add(cur);
20            else{
21                max=Math.max(cur,max);
22                 min=Math.min(cur,min);
23            }
24            parity=(parity+1)%2;
25        }
26        Collections.sort(list);
27        int m=list.size();
28        if(m>0){
29          max=Math.max(list.get(m-1)-1,max);
30            min=Math.min(list.get(0)+1,min);
31        }
32             res1=list.size();
33             res=max-min;
34        parity=1;list.clear();
35        max=-maxi;min=maxi;
36         for(int i=0;i<n;i++){
37            int cur=nums[i];
38            if((Math.abs(nums[i])%2)!=parity) list.add(cur);
39            else{
40                max=Math.max(cur,max);
41                 min=Math.min(cur,min);
42            }
43            parity=(parity+1)%2;
44        }
45        Collections.sort(list);
46        m=list.size();
47        if(m>0){
48          max=Math.max(list.get(m-1)-1,max);
49            min=Math.min(list.get(0)+1,min);
50        }
51        if(list.size()<=res1){
52             if(list.size()==res1)  res=Math.min(res,max-min);
53           else res=Math.max(0,max-min);
54             res1=Math.min(res1,list.size());
55            
56        }
57        if(res<0)  return new int []{res1,0};
58        return new int []{res1,res};
59    }
60}