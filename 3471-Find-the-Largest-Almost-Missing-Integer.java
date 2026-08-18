class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans=-1;
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
         for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
           
          
        }
        if(k==1){
         for(int i=0;i<n;i++){
           if(map.get(nums[i])==1) ans=Math.max(nums[i],ans);
        }
            
        }
         if(k==n){
         for(int i=0;i<n;i++){
          ans=Math.max(nums[i],ans);
        }
         }
       
           if(map.get(nums[0])==1) ans=Math.max(nums[0],ans);
          if(map.get(nums[n-1])==1) ans=Math.max(nums[n-1],ans);
        
       return ans;
        
    }
}