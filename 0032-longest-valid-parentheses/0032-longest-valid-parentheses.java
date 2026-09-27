class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> ss = new Stack<>();
        ss.push(-1);
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                ss.push(i);
            }else{
                ss.pop();

                if(ss.isEmpty()){
                    ss.push(i);
                }else{
                    ans = Math.max(ans, i - ss.peek());
                }
            }
        }

        return ans;
    }
}