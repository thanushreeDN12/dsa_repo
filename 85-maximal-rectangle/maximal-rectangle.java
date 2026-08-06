class Solution {
    
    public int largestRectangleArea(int[] arr) {
        
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        int max= 0;

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int element= arr[st.peek()];
                st.pop();
                int nse= i;
                int pse= st.isEmpty() ? -1: st.peek();
                max= Math.max(max, (nse- pse -1)*element);
                
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element= arr[st.pop()];
            int nse= n;
            int pse= !st.isEmpty() ? st.peek() : -1;
            max= Math.max(max, (nse- pse -1)*element);


        }
       
        return max;
        
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
}