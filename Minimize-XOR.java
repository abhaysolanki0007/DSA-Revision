1class Solution {
2    public int minimizeXor(int num1, int num2) {
3        int a=Integer.bitCount(num1);
4        int b=Integer.bitCount(num2);
5        int diff=a-b;
6        if(diff>0){
7            for(int i=0;i<31;i++){
8                 if(diff==0) break;
9              if((num1&(1<<i))!=0){
10                    num1-=(1<<i);
11                    diff--;
12                }
13            }
14        }
15        else{
16            for(int i=0;i<31;i++){
17                if(diff==0) break;
18                if((num1&(1<<i))==0){
19                    num1|=(1<<i);
20                    diff++;
21                }
22            }
23        }
24        return num1;
25    }
26}