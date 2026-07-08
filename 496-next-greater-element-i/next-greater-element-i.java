class Solution{
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] ans= new int[nums1.length];
        int[] temp= new int[nums2.length];
        Stack<Integer> st= new Stack<>();

        for(int i=nums2.length-1; i>=0; i--){
                while(!st.isEmpty() && st.peek()< nums2[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    temp[i]= -1;
                }else{
                    temp[i]= st.peek();
                }
                st.push(nums2[i]);
        }
        
        //O(logn)
        HashMap<Integer, Integer> mp= new HashMap<>();
        for(int i=0; i< temp.length; i++){
            mp.put(nums2[i], temp[i]);
        }
        for(int i=0; i< nums1.length; i++){
            ans[i]= mp.get(nums1[i]);
        }


        // again O(n1 * n2)
        // for(int i=0; i<nums1.length; i++){
        //     for(int j=0; j<nums2.length; j++){
        //         if (nums2[j] ==nums1[i]){
        //             ans[i]= temp[j];
        //             break;
        //         }
        //     }
        // }
        return ans;
    }
}





//  O(n1 * n2)
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] ans= new int[nums1.length];
//         for(int i=0; i< nums1.length; i++){
            
//             Stack<Integer> st= new Stack<>();

//             for(int j=nums2.length-1; j>=0; j--){

//                 if(st.isEmpty()){

//                     if(nums2[j]== nums1[i]){
//                         ans[i]= -1;
//                         break;
//                     }
//                     st.push(nums2[j]);
//                 }else{
//                     if(st.peek() > nums2[j]){
//                         if(nums2[j]== nums1[i]){
//                             ans[i]= st.peek();
//                             break;
//                         }
//                         st.push(nums2[j]);
//                     }else{
//                         if(nums2[j]== nums1[i]){
//                             while(!st.isEmpty() && st.peek()<nums2[j]){
//                                 st.pop();
//                             }if(st.isEmpty()){
//                                 ans[i]= -1;
//                             }else{
//                                 ans[i]= st.peek();

//                             }
//                             break;
//                         }else{
//                             while(!st.isEmpty() && st.peek()<nums2[j]){
//                                 st.pop();
//                             }
//                             st.push(nums2[j]);
//                         }
//                     }
//                 }
//             }
//         }
//         return ans;
//     }
// }