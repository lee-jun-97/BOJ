import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {        
        Set<Character> set = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : skip.toCharArray()) {
            set.add(c);
        }
        
        for(char c : s.toCharArray()) {
            int index_tmp = 1;
            while(index_tmp <= index) {
                c += 1;
                
                if(c > 'z') {
                    c = 'a';
                }
                
                if(!set.contains(c)) {
                    index_tmp++;
                }
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}