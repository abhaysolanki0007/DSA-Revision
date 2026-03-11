1class Solution {
2    public int[] lexSmallestNegatedPerm(int n, long target) {
3        long totalsum=(long)n*(n+1)/2;
4        
5        if(target>totalsum||target<(-totalsum)) return new int[0];
6       long diff=0;
7        List<Integer>list=new ArrayList<>();
8         List<Integer>ans=new ArrayList<>();
9        for(int i=0;i<n;i++){
10            list.add(i+1);
11        }
12        while(target<totalsum){
13             diff=totalsum-target;
14            int size=list.size();
15            if(diff>=2*list.get(size-1)){
16                totalsum-=(2*list.get(size-1));
17                 ans.add(-list.get(size-1));
18                list.remove(size-1);
19            }
20            else break;
21        }
22          diff=totalsum-target;
23            int j=list.size()-1;
24        while(j>=0){
25            if(2*list.get(j)==diff){
26                ans.add(-list.get(j));
27                 totalsum-=diff;
28                 list.remove(j);
29                break;
30            }
31            j--;
32        }
33        if(totalsum-target!=0) return new int[0];
34        for(int i=0;i<list.size();i++){
35            ans.add(list.get(i));
36        }
37        return ans.stream().mapToInt(i -> i).toArray();
38    }
39}