import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> count_map = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new ArrayList<>());
        }
        
        for(String str : report) {
            if(!set.contains(str)) {
                String[] arr = str.split(" ");
                map.get(arr[0]).add(arr[1]);
                count_map.put(arr[1], count_map.getOrDefault(arr[1], 0) + 1);
                set.add(str);
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            for(String j : map.get(id_list[i])) {
                if(count_map.get(j) >= k) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}