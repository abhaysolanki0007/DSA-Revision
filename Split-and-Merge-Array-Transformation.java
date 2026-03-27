1class Pair {
2    List<Integer> list;
3    int c;
4    Pair(List<Integer> list, int c) {
5        this.list = list;
6        this.c = c;
7    }
8}
9class Solution {
10   public boolean equal(int nums[], List<Integer> list) {
11        int n = nums.length;
12        for (int i = 0; i < n; i++) {
13            if (nums[i] != list.get(i)) return false;
14        }
15        return true;
16    }
17     public List<Integer> merge(List<Integer>list2,List<Integer>list,int k){
18        List<Integer>ans=new ArrayList<>();
19        for(int i=0;i<k;i++){
20            ans.add(list.get(i));
21        }
22        for(int a:list2){
23            ans.add(a);
24        }
25        for(int i=k;i<list.size();i++){
26             ans.add(list.get(i));
27        }
28        return ans;
29    }
30    public int minSplitMerge(int[] nums1, int[] nums2) {
31        int n = nums1.length;
32
33        Queue<Pair> q = new LinkedList<>();
34        List<Integer> start = Arrays.stream(nums1).boxed().toList();
35
36        if (equal(nums2, start)) return 0;
37          Set<List<Integer>>visited=new HashSet<>();
38
39        for(int i=0;i<n;i++){
40            for(int j=i;j<n;j++){
41                List<Integer>list=new ArrayList<>();
42                List<Integer>list2=new ArrayList<>();
43                  for(int id=i;id<=j;id++){
44                    list2.add(nums1[id]);
45                }
46                for(int id=0;id<i;id++){
47                    list.add(nums1[id]);
48                }
49                 for(int id=j+1;id<n;id++){
50                    list.add(nums1[id]);
51                }
52                for(int k=0;k<=list.size();k++){
53                    visited.add(merge(list2,list,k));
54                    q.offer(new Pair(merge(list2,list,k),1));
55                }
56            }
57        }
58      
59        while(q.size()>0){
60            Pair p=q.poll();
61             List<Integer>list3=p.list;
62            //  System.out.println(list3);
63             int count=p.c;
64               if(equal(nums2,list3)) return count;
65              for(int i=0;i<n;i++){
66            for(int j=i;j<n;j++){
67                List<Integer>list=new ArrayList<>();
68                List<Integer>list2=new ArrayList<>();
69                  for(int id=i;id<=j;id++){
70                    list2.add(list3.get(id));
71                }
72                for(int id=0;id<i;id++){
73                    list.add(list3.get(id));
74                }
75                 for(int id=j+1;id<n;id++){
76                    list.add(list3.get(id));
77                }
78                for(int k=0;k<=list.size();k++){
79                    List<Integer>newlist=merge(list2,list,k);
80                    Pair pair=new Pair(newlist,count+1);
81                    if(!visited.contains(newlist)){
82                        q.offer(pair);
83                        visited.add(newlist);
84                    }
85                }
86            }
87        }
88        }
89        return 0;
90    }
91}