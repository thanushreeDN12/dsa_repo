class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int n= arr.length;
        List<Integer> ans= new ArrayList<>();


        for(int i=0; i<n; i++){
            if(arr[i] >0){
                st.push(arr[i]);
            }else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()< Math.abs(arr[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()> 0){
                    if(Math.abs(arr[i]) == st.peek()){
                        st.pop();
                    }
                }else{
                    st.push(arr[i]);
                }
                
            }
        }
        int i= 0;
        while(!st.isEmpty()){
            ans.add(i, st.pop());
            i++;
        }

        int[] res= new int[ans.size()];
        for(int j=0; j<res.length; j++){
            res[j]= ans.get(ans.size()-1-j);
        }
        return res;

        
    }
}