class Solution {
    public String removeDuplicates(String s) {
        if(s.length() == 0){
            return "";
        }
        Stack<Character> ss = new Stack<>();
        ss.push(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            if(!ss.isEmpty()){
                if(ss.peek() != s.charAt(i)){
                    ss.push(s.charAt(i));
                }else{
                    ss.pop();
                }
            }else{
                ss.push(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();

        for(char ch : ss){
            ans.append(ch);
        }

        return ans.toString();
    }
}