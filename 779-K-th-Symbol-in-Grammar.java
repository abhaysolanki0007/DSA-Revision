class Solution {
    public int kthGrammar(int n, int k) {
        int c=0;
        while(n!=1){
        int pow=(int)(Math.pow(2,n-1));
        int half=pow/2;
        if(k>half){c++; k-=half;}
        n--;
       
        }
        return c%2;
    }
}