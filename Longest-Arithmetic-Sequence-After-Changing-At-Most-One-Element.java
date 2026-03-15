1class Solution {
2    public void reverse(int nums[]){
3        int i=0,j=nums.length-1;
4        while(i<j){
5            int temp=nums[i];
6            nums[i]=nums[j];
7            nums[j]=temp;
8            i++;j--;
9        }
10    }
11    public int tic(int[] nums) {
12        List<Integer>list=new ArrayList<>();
13        int n=nums.length,ans=0;
14        int diff[]=new int[n];
15        diff[0]=0;
16        for(int i=1;i<n;i++){
17            diff[i]=nums[i]-nums[i-1];
18        }
19         int c=2,prev=diff[1];
20         int prefix[]=new int[n];
21         Arrays.fill(prefix,2);
22        
23         for(int i=2;i<n;i++){
24          if(diff[i]==prev) c++;
25          else c=2;
26          prefix[i]=c;
27          ans=Math.max(ans,c+1);
28          prev=diff[i];
29        }
30         int suffix[]=new int[n];
31        prev=diff[n-1];
32         Arrays.fill(suffix,2);
33        c=2;
34           for(int i=n-2;i>=1;i--){
35           if(diff[i]==prev) c++;
36          else c=2;
37          suffix[i-1]=c;
38          ans=Math.max(ans,c+1);
39          prev=diff[i];
40        }
41        
42         for(int i=1;i<n-2;i++){
43           if((float)diff[i]==(nums[i+2]-nums[i])/2.0){
44            if(i+3<n&&diff[i+3]==diff[i]){
45                ans=Math.max(ans,prefix[i]+suffix[i+2]+1);
46            }
47            else {
48                ans=Math.max(ans,prefix[i]+2);
49            }
50           }
51         }
52        //   for(int i=0;i<n;i++){
53        //     System.out.print(suffix[i]+" ");
54        //  }
55        //   System.out.println();
56        //   for(int i=0;i<n;i++){
57        //     System.out.print(prefix[i]+" ");
58        //  }
59        //   System.out.println();
60        //   for(int i=0;i<n;i++){
61        //     System.out.print(diff[i]+" ");
62        //  }
63        //   System.out.println();
64        return Math.min(n,ans);
65    }
66        public int longestArithmetic(int[] nums) {
67            int res=0;
68            res=Math.max(res,tic(nums));
69            reverse(nums);
70             res=Math.max(res,tic(nums));
71             return res;
72        }
73
74}