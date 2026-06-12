1class Solution {
2    public boolean equal(  PriorityQueue<Integer>heap,int i,int j,int nums[]){
3      PriorityQueue<Integer>heap2=new PriorityQueue<>(heap);
4        int c=0;
5        for(int k=i;k<=j;k++){
6            if(heap2.poll()!=nums[k]) return false;
7            c++;
8        }
9        return true;
10    }
11    public int maxChunksToSorted(int[] arr) {
12        PriorityQueue<Integer>heap=new PriorityQueue<>();
13        int n=arr.length;
14        int nums[]=arr.clone();
15        Arrays.sort(nums);
16        int i=0,j=0,c=0;
17        for(int a:arr){
18           // add in tree map
19           heap.offer(a);
20            if(equal(heap,i,j,nums)){
21                c++;i=j+1;
22                heap.clear();
23            }
24            j++;
25        }
26        return c;
27    }
28}