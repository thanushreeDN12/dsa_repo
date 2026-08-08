class StockSpanner {

    private List<Integer> nums;
    private List<Integer> ans;   
    private Stack<Integer> st;
    private int i;

    public StockSpanner() {
        nums = new ArrayList<>();
        ans = new ArrayList<>();   
        st = new Stack<>();
        i = -1;
    }
    
    public int next(int price) {
        nums.add(price);
        i= i+1;

        while(!st.isEmpty() && nums.get(st.peek()) <= nums.get(i)){
            st.pop();
        }
        int pgeindex= !st.isEmpty() ? st.peek() : -1;
        int span= i- pgeindex;
        st.push(i);
        ans.add(span);
        return span;



    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */