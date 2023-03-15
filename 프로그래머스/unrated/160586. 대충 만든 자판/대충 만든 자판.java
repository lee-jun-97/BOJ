import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(String str : keymap) {
            for(int i=0; i<str.length(); i++) {
                char temp = str.charAt(i);
                if(map.containsKey(temp)) {
                    map.put(temp, Math.min(i + 1, map.get(temp)));
                } else {
                    map.put(temp, i + 1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            int result = 0;
            for(char c : targets[i].toCharArray()) {
                if(!map.containsKey(c)) {
                    result = -1;
                    break;
                } else {
                    result += map.get(c);
                }
            }
            
            answer[i] = result;
        }
        return answer;
    }
}