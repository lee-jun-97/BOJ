class Solution {
    
    String[] str_arr = { "aya", "ye", "woo", "ma" };
    
    public int solution(String[] babbling) {
        int answer = 0;        
        
        for(String i : babbling) {
            System.out.println(i);
            if(recursion(i, " ")) {
                answer++;
            }
        }
        return answer;
    }
    
    boolean recursion(String str, String prev_str) {
        if(str.equals("")) {
            return true;
        }
        
        for(String i : str_arr) {
            if(prev_str.equals(i)) {
                continue;
            } else if(str.startsWith(i)){
                if(recursion(str.substring(i.length()), i)) {
                    return true;
                };
            }
        }
        
        return false;
    }
}