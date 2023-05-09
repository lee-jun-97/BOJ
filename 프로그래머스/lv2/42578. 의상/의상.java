import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] i : clothes) {
            map.put(i[1], map.getOrDefault(i[1], 1) + 1);
        }
        
        int sum = 1;
        
        for(String i : map.keySet()) {
            sum *= map.get(i);
        }
        
        answer += sum;
        
        return answer - 1;
    }
}