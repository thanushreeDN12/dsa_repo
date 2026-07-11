class Solution {
    public String removeKdigits(String num, int k) {
        int n= num.length();
        Stack<Character> st= new Stack<>();

        for(int i=0; i<n; i++){
            char digit= num.charAt(i);  
            while(!st.isEmpty() && st.peek() > digit && k>0){
                    st.pop();
                    k--;
            }
            st.push(digit);
            
        }
        while(k >0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";

        StringBuilder ans= new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        while(ans.length() >0 && ans.charAt(ans.length()-1)=='0'){
            ans.deleteCharAt(ans.length()-1);
        }
        if (ans.length()==0) return "0";
        ans.reverse();
        return ans.toString();
        
    }
}