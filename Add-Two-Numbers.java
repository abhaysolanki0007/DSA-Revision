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
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        int n1=0,n2=0;
14        ListNode temp=l1;
15         ListNode temp2=l2;
16         while(temp!=null){
17            n1++;
18            temp=temp.next;
19         }
20          while(temp2!=null){
21            n2++;
22            temp2=temp2.next;
23         }
24         ListNode  prev=null;
25         temp=l1;
26         temp2=l2;
27         if(n1>=n2){
28             int rem=0;
29            while(temp!=null&&temp2!=null){
30                int t=(temp.val+temp2.val+rem);
31            temp.val=(temp.val+temp2.val+rem)%10;
32            rem=t/10;
33            prev=temp;
34            temp=temp.next;
35            temp2=temp2.next;
36         }
37         while(temp!=null){
38            int t1=(temp.val+rem);
39            temp.val=(temp.val+rem)%10;
40            rem=t1/10;
41             prev=temp;
42            temp=temp.next;
43         }
44        if(rem>0) prev.next=new ListNode(1);
45         return l1;
46         }
47         else{
48             int rem=0;
49            while(temp!=null&&temp2!=null){
50           int t=(temp.val+temp2.val+rem);
51            temp2.val=(temp.val+temp2.val+rem)%10;
52            rem=t/10;
53            prev=temp2;
54            temp=temp.next;
55            temp2=temp2.next;
56         }
57         while(temp2!=null){
58            int t1=(temp2.val+rem);
59            temp2.val=(temp2.val+rem)%10;
60            rem=t1/10;
61             prev=temp2;
62            temp2=temp2.next;
63         }
64         if(rem>0){
65            prev.next=new ListNode(1);
66         }
67         return l2;
68         }
69    }   
70}