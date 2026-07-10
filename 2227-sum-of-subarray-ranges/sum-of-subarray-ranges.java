class Solution {
    
    // FOR SUM OF SUBARRAY MINIMUMS
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

    // it is previous smaller or equal element to handle edge case ex.[1,1]
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

    public long sumSubarrayMins(int[] arr) {
        //int mod = 1_000_000_007;
        long sum=0;
        int[] nse= NSE(arr);
        int[] psee= PSEE(arr);

        for(int i=0; i<arr.length; i++){
            int left= i- psee[i];
            int right= nse[i]- i;

            long freq = (long) left * right;
            long val = (freq * arr[i]);
            sum = (sum + val);
        }
        return sum;
        
    }

    //FOR SUM OF SUBARRAY MAXIMUMS
    //we store index of nse in the ans, not the actual element
    public int[] NGE(int[] arr){
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
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

    // it is previous smaller or equal element to handle edge case ex.[1,1]
    public int[] PGEE(int[] arr){
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[arr.length];

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]< arr[i]){
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

    public long sumSubarrayMaxs(int[] arr) {
        //int mod = 1_000_000_007;
        long sum=0;
        int[] nse= NGE(arr);
        int[] pgee= PGEE(arr);

        for(int i=0; i<arr.length; i++){
            int left= i- pgee[i];
            int right= nse[i]- i;

            long freq = (long) left * right;
            long val = (freq * arr[i]) ;
            sum = (sum + val) ;
        }
        return sum;
        
    }

    public long subArrayRanges(int[] arr) {
        return sumSubarrayMaxs(arr)- sumSubarrayMins(arr);
        
    }
}


// Brute force O(n^2)
// class Solution {
//     public long subArrayRanges(int[] arr) {
//         int n= arr.length;
//         long sum=0;
//         for(int i=0; i<n; i++){

//             long min= arr[i];
//             long max= arr[i];

//             for(int j=i; j<n; j++){
//                 min= (Math.min(arr[j], min));
//                 max= (Math.max(arr[j], max));
//                 sum += (max- min);
//             }
//         }
//         return sum;
//     }
// }


