class Solution {
    public String  rev(String str){
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        String reversed = new String(charArray);
        return reversed;
    }
    public String smallestPalindrome(String s) {
        int n=s.length();
        int ind=-1;
        int freqarr[]=new int [26];
        for(int i=0;i<n;i++){
            freqarr[s.charAt(i)-'a']++;
        }
        
        StringBuilder st=new StringBuilder();
         for(int i=0;i<26;i++){
             int f=freqarr[i];
             if(f==0) continue;
             if(f%2!=0) ind=i;
             f/=2;
             while(f>0){
                 st.append((char)('a'+i));
                 f--;
             }
         }
        String str=rev(st.toString());
        if(ind!=-1) st.append((char)('a'+ind));
        st.append(str);
        return st.toString();
        
    }
}