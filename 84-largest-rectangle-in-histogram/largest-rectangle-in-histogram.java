class Solution {

    public int[] NSE(int[] arr){
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            ans[i]= !st.isEmpty()? st.peek(): arr.length;
            st.push(i);
        }
        return ans;
    }

    // it is previous smaller or equal element to handle edge case ex.[1,1]
    public int[] PSE(int[] arr){
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[arr.length];

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]> arr[i]){
                st.pop();
            }
            ans[i]= !st.isEmpty()? st.peek(): -1;

            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] arr) {
        int[] nse= NSE(arr);
        int[] pse= PSE(arr);

        int max= 0;
        for(int i=0; i< arr.length; i++){
            max= Math.max(max, (nse[i]-pse[i]-1)*arr[i]);
        }
        return max;
        
    }
}