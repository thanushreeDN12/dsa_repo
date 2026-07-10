class Solution {
    //we store index of nse in the ans, not the actual element
    public int[] NSE(int[] arr){
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]= st.peek();
            }else{
                ans[i]= arr.length;
            }
            st.push(i);
        }
        return ans;
    }

    public int[] PSEE(int[] arr){
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[arr.length];

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]> arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]= st.peek();
            }else{
                ans[i]= -1;
            }
            st.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int sum=0;
        int[] nse= NSE(arr);
        int[] psee= PSEE(arr);

        for(int i=0; i<arr.length; i++){
            int left= i- psee[i];
            int right= nse[i]- i;

            long freq = (long) left * right;
            long val = (freq * arr[i]) % mod;
            sum = (int)((sum + val) % mod);
        }
        return sum;
        
    }
}