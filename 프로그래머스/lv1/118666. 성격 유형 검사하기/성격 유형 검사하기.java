import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        for(int i=0; i<choices.length; i++) {
            if(choices[i] < 4){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + Math.abs(4 - choices[i]));
            } else {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + Math.abs(4 - choices[i]));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(map.get('R') >= map.get('T')) {
            sb.append('R');
        } else {
            sb.append('T');
        }
        
        if(map.get('C') >= map.get('F')) {
            sb.append('C');
        } else {
            sb.append('F');
        }
        
        if(map.get('J') >= map.get('M')) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        
        if(map.get('A') >= map.get('N')) {
            sb.append('A');
        } else {
            sb.append('N');
        }
        
        return sb.toString();
    }
}