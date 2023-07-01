import java.util.*;

class Solution {
    
    Map<Integer, List<String>> map = new HashMap<>();
    Map<String, Integer> c_map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for(String str : orders) {
            for(int i : course) {
                boolean[] visited = new boolean[str.length()];
                combi(str.toCharArray(), visited, 0, str.length(), i);
            }

        }
        
        List<String> result_list = new ArrayList<>();
        
        for(int i : course) {
            List<String> list = new ArrayList<>();

            if(map.get(i) == null) {
                continue;
            }

            for(String j : map.get(i)) {
                if(list.isEmpty() || (c_map.get(list.get(0)) == c_map.get(j)) ) {
                    if(!list.contains(j) && c_map.get(j) >= 2) {
                        list.add(j);
                    }
                } else {
                    if(c_map.get(list.get(0)) < c_map.get(j) && !list.contains(j) && c_map.get(j) >= 2) {
                        list.removeAll(list);
                        list.add(j);
                    }
                }
            }

            for(String j : list) {
                result_list.add(j);
            }
        }
        
        Collections.sort(result_list);
        
        String[] answer = new String[result_list.size()];
        
        for(int i=0; i<result_list.size(); i++) {
            answer[i] = result_list.get(i);
            System.out.println(answer[i]);
        }
        
        return answer;
    }
        
    
    // start = 현재 뽑은 길이 , str = 문자열, n = 전체 길이 r = 뽑을 조합의 길이
    void combi(char[] str, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) {
                    sb.append(str[i]);
                }
            }
            
            char[] temp = sb.toString().toCharArray();
        
            Arrays.sort(temp);  
            
            String temp_str = new String(temp);
            
            if(temp_str.length() >= 2) {
                
                if(map.get(temp_str.length()) == null) {
                    map.put(temp_str.length(), new ArrayList<>());
                }
                
                map.get(temp_str.length()).add(temp_str);
                c_map.put(temp_str, c_map.getOrDefault(temp_str, 0) + 1);
            }
            return ;
        }
        
        for(int i=start; i<n; i++) {
            visited[i] = true;
            combi(str, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}