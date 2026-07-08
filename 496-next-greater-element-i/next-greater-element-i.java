class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans= new int[nums1.length];
        for(int i=0; i< nums1.length; i++){
            
            Stack<Integer> st= new Stack<>();

            for(int j=nums2.length-1; j>=0; j--){

                if(st.isEmpty()){

                    if(nums2[j]== nums1[i]){
                        ans[i]= -1;
                        break;
                    }
                    st.push(nums2[j]);
                }else{
                    if(st.peek() > nums2[j]){
                        if(nums2[j]== nums1[i]){
                            ans[i]= st.peek();
                            break;
                        }
                        st.push(nums2[j]);
                    }else{
                        if(nums2[j]== nums1[i]){
                            while(!st.isEmpty() && st.peek()<nums2[j]){
                                st.pop();
                            }if(st.isEmpty()){
                                ans[i]= -1;
                            }else{
                                ans[i]= st.peek();

                            }
                            break;
                        }else{
                            while(!st.isEmpty() && st.peek()<nums2[j]){
                                st.pop();
                            }
                            st.push(nums2[j]);
                        }
                    }
                }
            }
        }
        return ans;
    }
}