class Solution {
    public String longestPalindrome(String input) {
        
        String res="";

        if(input=="")return "";
        if(input.length()==1) return input;
        if(input.length()==2){
            if(input.charAt(0)==input.charAt(1))
                return input;
            return String.valueOf(input.charAt(0));
        }
        String pallindromeLength= String.valueOf(input.charAt(0));

        for(int i=0;i<input.length();i++){

            int st=i;
            int end=i;

            pallindromeLength=input.substring(st, i+1);

            while(st>=0&&end<input.length() && input.charAt(st)==input.charAt(end)){
                pallindromeLength=input.substring(st, end+1);
                st--;
                end++;
            }
            if(res.length()<=pallindromeLength.length())
                res=new String(pallindromeLength);
                
            st=i;
            end=i+1;

            pallindromeLength=input.substring(st, i+1);

            while(st>=0&&end<input.length() && input.charAt(st)==input.charAt(end)){
                pallindromeLength=input.substring(st, end+1);
                st--;
                end++;
            }

            if(res.length()<=pallindromeLength.length())
                res=new String(pallindromeLength);
        }
        return res;
    }
}