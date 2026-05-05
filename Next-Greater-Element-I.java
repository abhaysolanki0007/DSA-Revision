1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        Stack<Integer>st=new Stack<>();
4        int n=nums2.length;
5        int ans[]=new int[nums1.length];
6        Map<Integer,Integer>map=new HashMap<>();
7        for(int i=n-1;i>=0;i--){
8            while(st.size()>0&&st.peek()<nums2[i]){
9                st.pop();
10            }
11            if(st.size()==0){
12                 map.put(nums2[i],-1);
13            }
14            else map.put(nums2[i],st.peek());
15            st.push(nums2[i]);
16        }
17        for(int i=0;i<nums1.length;i++){
18            ans[i]=map.get(nums1[i]);
19        }
20        return ans;
21        
22    }
23}