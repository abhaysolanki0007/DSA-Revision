class Solution {
    public int lowerbound(int val,int nums[]){
        int n=nums.length,ans=0;
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<=val){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;

    }
    public long perfectPairs(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=lowerbound(2*nums[i],nums)-i;
        }
        return ans;
    }
}