1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12   
13    public ListNode mergeKLists(ListNode[] lists) {
14        
15        List<ListNode>list=new ArrayList<>();
16        for( ListNode node:lists){
17            
18           while(node!=null){
19            list.add(node);
20            node=node.next;
21        }
22        }
23        list.sort(Comparator.comparingInt(node -> node.val));
24        int n=list.size();
25        for(int i=0;i<n-1;i++){
26            ListNode cur=list.get(i);
27            cur.next=list.get(i+1);
28        }
29        if(list.size()==0) return null;
30        return list.get(0);
31    }
32}