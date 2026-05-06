1class Solution {
2    public char[][] rotateTheBox(char[][] box) {
3        int n=box.length,m=box[0].length;
4        char ans[][]=new char[m][n];
5         for(char row[]:ans){
6            Arrays.fill(row,'.');
7        }
8        for(int i=0;i<n;i++){
9            for(int j=0;j<m;j++){
10                if(box[i][j]=='*') ans[j][n-1-i]='*';
11            }
12        }
13        for(int i=n-1;i>=0;i--){
14            int j=m-1;
15            while(j>=0){
16                int c=0;
17                int t=j;
18                while(j>=0){
19                    System.out.println(box[i][j]);
20                    if(box[i][j]=='*'){j--;break;}
21                    if(box[i][j]=='#') c++;
22                    j--;
23                }
24                for(int k=t;k>j;k--){
25                   if(c>0){ans[k][n-1-i]='#';c--;}
26                }
27            }
28        }
29        return ans;
30    }
31}