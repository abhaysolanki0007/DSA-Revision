1class Solution {
2    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
3        TreeMap<Integer,Integer>map=new TreeMap<>();
4        int n=startTime.length;
5        int arr[][]=new int[n][2];
6        for(int i=0;i<n;i++){
7            arr[i][0]=startTime[i];
8            arr[i][1]=endTime[i];
9        }
10         for(int i=1;i<n;i++){
11            int val=arr[i][0]-arr[i-1][1];
12           map.put(val,map.getOrDefault(val,0)+1);
13        }
14        int ans=0;
15        map.put(arr[0][0],map.getOrDefault(arr[0][0],0)+1);
16          map.put(eventTime-arr[n-1][1],map.getOrDefault(eventTime-arr[n-1][1],0)+1);
17        for(int i=0;i<n;i++){
18            // arr[i][0]=startTime[i];
19            int val1=arr[i][0];
20            int val2=eventTime-arr[i][1];
21            if(i>0) val1=arr[i][0]-arr[i-1][1];
22            if(i<n-1) val2=arr[i+1][0]-arr[i][1];
23              map.put(val1,map.get(val1)-1);
24                map.put(val2,map.get(val2)-1);
25                if(map.get(val1)==0) map.remove(val1);
26                if(val1!=val2&&map.get(val2)==0) map.remove(val2);
27                // System.out.print(map.get(val2));
28
29                if(map.ceilingKey(arr[i][1]-arr[i][0])!=null){
30                    ans=Math.max(ans,val1+val2+arr[i][1]-arr[i][0]);
31                }
32                map.put(val1,map.getOrDefault(val1,0)+1);
33                 map.put(val2,map.getOrDefault(val2,0)+1);
34                 ans=Math.max(ans,val1+val2);
35        }
36        return ans;
37        
38    }
39}