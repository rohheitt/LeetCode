class Solution {
    public int mySqrt(int x) {
       int start = 0;
       int end = x;

       while(start <= end){
        int mid = start + (end - start)/ 2;
        long m = (long)mid * mid;
        if(m == x){
            return mid;
        }
        if(m > x){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
       }

       return end;
    }
}