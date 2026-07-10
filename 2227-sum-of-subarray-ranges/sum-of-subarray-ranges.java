class Solution {
    public long subArrayRanges(int[] arr) {
        int n= arr.length;
        long sum=0;
        for(int i=0; i<n; i++){

            long min= arr[i];
            long max= arr[i];

            for(int j=i; j<n; j++){
                min= (Math.min(arr[j], min));
                max= (Math.max(arr[j], max));
                sum += (max- min);
            }
        }
        return sum;
    }
}


// class Solution {
//     public long subArrayRanges(int[] nums) {
        
//     }
// }