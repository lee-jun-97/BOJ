import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        Map<Character, Integer> y_map = new HashMap<>();
        
        for(char c : Y.toCharArray()) {
            y_map.put(c, y_map.getOrDefault(c, 0) + 1);
        }
        
        List<Character> list = new ArrayList<>();
        
        for(char c : X.toCharArray()) {
            if(y_map.containsKey(c) && y_map.get(c) > 0) {
                y_map.put(c, y_map.get(c) - 1);
                list.add(c);
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        if(list.size() > 0) {
            for(char c : list) {
                sb.append(c);
            }
            
            if(sb.charAt(0) == '0') {
                return "0";
            }
        } else {
            return "-1";
        }
        
        
        return String.valueOf(sb.toString());
    }
}