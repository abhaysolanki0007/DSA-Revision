1class Solution {
2    public long moves(int i,int arr[]){
3        int n=arr.length;
4        int val=arr[i];
5        long c=0;
6        int j=i-1,k=i+1;
7        j=(j+n)%n;k=(k)%n;
8        while(val<0){
9             j=(j+n)%n;k=(k)%n;
10            if(val<0){
11                int min1=Math.min(arr[j],Math.abs(val));
12                val+=min1;
13                c+=(long)Math.min(Math.abs(j-i),Math.abs(i+n-j))*min1;
14            }
15             if(val<0){
16                int min2=Math.min(arr[k],Math.abs(val));
17                val+=min2;
18                c+=(long)Math.min(Math.abs(k-i),Math.abs(k-i+n))*min2;
19            }
20            j--;k++;
21        }
22        return c;
23    }
24    public long minMoves(int[] balance) {
25        long ans=0,sum=0;
26        int n=balance.length;
27        for(int i=0;i<n;i++){
28            sum+=balance[i];
29        }
30        if(sum<0) return -1;
31        for(int i=0;i<n;i++){
32            if(balance[i]<0){
33                ans+=(long)moves(i,balance);
34            }
35        }
36        return ans;
37    }
38}