1class Solution {
2    public int minNumberOperations(int[] nums) {
3        // return 0;
4        int n=nums.length,ans=0;
5        Stack<Integer>st=new Stack<>();
6        for(int i=0;i<n;i++){
7            if(st.size()>0&&st.peek()>nums[i]){
8                   ans+=st.pop()-nums[i];
9                }
10                 while(st.size()>0&&st.peek()>nums[i]){
11                   st.pop();
12                }
13                if(st.size()==0) st.push(nums[i]);
14             else if(st.size()>0&&st.peek()!=nums[i]) st.push(nums[i]);
15        }
16        if(st.size()>0) ans+=st.pop();
17        return ans;
18    }
19}