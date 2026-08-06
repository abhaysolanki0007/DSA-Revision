class Solution {
    public long maxTotal(int[] nums, String s) {
        long ans=0;
        int n=nums.length,i=0;
       while(i<n){
        int prev=0,min=(int)(1e9),c=0;
        long sum=0;
        while(i<n&&s.charAt(i)=='0'){ c++;prev=i;i++;}
         while(i<n&&s.charAt(i)=='1'){
            min=Math.min(min,nums[i]);
            sum+=nums[i];i++;
         }
         if(c>=1){min=Math.min(min,nums[prev]);sum+=nums[prev];
         ans+=sum-min;
         }
         else ans+=sum;
        }
        return ans;
    }
}