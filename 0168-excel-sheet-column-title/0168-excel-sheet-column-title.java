class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder s = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; 
            int remainder = columnNumber % 26;
            s.append((char) ('A' + remainder));
            columnNumber /= 26;
        }
        
        return s.reverse().toString();
    }
}