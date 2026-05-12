1class Solution {
2    public int minOperations(int[] nums) {
3        List<Integer>primes=new ArrayList<>();
4        int n=nums.length,maxi=0;
5        for(int a:nums){
6            maxi=Math.max(maxi,a);
7        }
8        maxi*=3;
9        TreeSet<Integer>set=new TreeSet<>();
10        int arr[]=new int[maxi];
11          for (int i =2; i * i < maxi; i++) {
12            if (arr[i]==0) {
13                for (int j = i * i; j < maxi; j += i) {
14                   arr[j]=1;
15                }
16            }
17        }
18        for(int i=2;i<maxi;i++){
19            if(arr[i]==0) set.add(i);
20        }
21        int flag=0;
22        int opn=0,ans= 100000000;
23        for(int i=0;i<n;i++){
24            if(flag==0){
25               if(!set.contains(nums[i])) opn+=set.ceiling(nums[i])-nums[i];
26                // System.out.println(set.ceiling(nums[i]));
27            }
28            else{
29                int temp=nums[i];
30                while(set.contains(temp)){
31                    temp++;
32                    opn++;
33                }
34            }
35            flag=(flag+1)%2;
36        }
37          ans=Math.min(ans,opn);
38        return ans;
39    }
40}