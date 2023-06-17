import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> map = new HashMap<>();
        char[] c_arr = msg.toCharArray();
        
        for(int i=0; i<26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<c_arr.length; i++) {
            sb.append(c_arr[i]);
            if(map.get(sb.toString()) != null) {
                continue;
            } else {
                map.put(sb.toString(), map.size() + 1);
                sb.deleteCharAt(sb.length() - 1);
                list.add(map.get(sb.toString()));
                sb.delete(0, sb.length());
                i--;
            }
        }
        
        if(sb.length() > 0) {
            list.add(map.get(sb.toString()));
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}