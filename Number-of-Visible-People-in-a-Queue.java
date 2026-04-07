1class Solution {
2    public int greater( List<Integer>list,int val){
3        int low=0,high=list.size()-1,ans=0;
4        while(low<=high){
5            int mid=(low+high)/2;
6            if(list.get(mid)<val){
7                high=mid-1;
8            }
9            else{ans=mid;low=mid+1;}
10        }
11        return ans;
12    }
13    public int[] canSeePersonsCount(int[] heights) {
14        List<Integer>list=new ArrayList<>();
15        int n=heights.length;
16        int ans[]=new int[n];
17        for(int i=n-1;i>=0;i--){
18            if(list.size()>0) ans[i]=list.size()-greater(list,heights[i]);
19            while(list.size()>0&&list.get(list.size()-1)<heights[i]) list.remove(list.size()-1);
20            list.add(heights[i]);
21        }
22        return ans;
23    }
24}