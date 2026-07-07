class Solution {
    public long sumAndMultiply(int n) {
        int x=0;
        int sum=0;
        int ans=0;
        while(n>0){
            
            int y= n %10;
            n= n/ 10;
            if(y != 0){
                x= x*10 + y;
            }

        }
         while(x>0){
            
            int y= x %10;
            x= x/ 10;
            ans= ans*10 + y;

         sum += y;
         }


        return (long)ans*sum;
        
    }
}