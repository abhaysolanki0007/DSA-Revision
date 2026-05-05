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
12    public ListNode rotateRight(ListNode head, int k) {
13        if(head==null) return null;
14         int c=0;
15        ListNode temp=head;
16        while(temp!=null){
17            c++;
18            if(temp.next==null){temp.next=head;break;}
19            temp=temp.next;
20        }
21         k=k%c;
22        temp=temp.next;
23        k=c-k;
24     if(k==0) return head;
25     k--;
26        while(k>0){
27            temp=temp.next;
28            k--;
29            
30        }
31        ListNode p=temp.next;
32        temp.next=null;
33        return p;
34      
35        
36    }
37}