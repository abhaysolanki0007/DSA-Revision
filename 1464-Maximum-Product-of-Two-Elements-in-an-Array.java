class Solution {
    public int maxProduct(int[] nums) {
        int max=0;
        int max1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                max1=(nums[i]-1)*(nums[j]-1);
                if(max1>max){
                    max=max1;}}}
        return max;

        
    }
}