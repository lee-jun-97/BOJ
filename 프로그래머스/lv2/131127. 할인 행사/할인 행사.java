import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);    
        }
        
        for(int i=0; i<=discount.length - 10; i++) {
            
            Map<String, Integer> discount_map = new HashMap<>();
            
            for(int j=i; j<i+10; j++) {
                discount_map.put(discount[j], discount_map.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean check = true;
            
            for(String str : map.keySet()) {
                if(map.get(str) != discount_map.get(str) || discount_map.get(str) == null) {
                    check = false;
                    break;
                }
            }
            
            if(check) {
                answer++;
            }
        }
        
        return answer;
    }
}