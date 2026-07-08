class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
       st= new Stack<>();
    }
    
    public void push(long val) {
        if(st.isEmpty()){
            st.push(val);
            min= val;
            return;
        }
        if(val< min){
            long y= (int)2* val- min;
            st.push(y);
            min= val;
        }else{
            st.push(val);
        }
        

    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long y= st.pop();
        if(y< min){
            min= 2* min- y;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long top= st.peek();
        if(top < min){
            return (int)min;
        }
        return (int)top;
    }
    
    public int getMin() {
         if(st.isEmpty()) return -1;
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */