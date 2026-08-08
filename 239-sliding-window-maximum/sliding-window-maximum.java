class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq= new LinkedList<>();
        List<Integer> list= new ArrayList<>();
        int i= 0;
        while( i<nums.length){
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            
            
            dq.offerLast(i);

            if(i>=k-1){
                list.add(nums[dq.peekFirst()]);
            }
            i++;
        }
        int[] arr= new int[list.size()];
        for(int j=0; j<arr.length; j++){
            arr[j]= list.get(j);
        }
        return arr;
    }
}