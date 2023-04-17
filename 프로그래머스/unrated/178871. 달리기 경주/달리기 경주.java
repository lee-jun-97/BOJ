import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        String[] answer = new String[players.length];
        
        Map<String, Integer> playerMap = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            playerMap.put(players[i], i + 1);
            rankMap.put(i + 1, players[i]);
        }
        
        for(String i : callings) {
            
            // 현재 선수 순위
            int rank = playerMap.get(i);
            // 바로 앞 선수 이름
            String name = rankMap.get(playerMap.get(i) - 1);
            // 바로 앞 선수 순위
            int rank_tmp = playerMap.get(name);
            
            // 현재 선수 위치로 바로 앞 선수 이동.
            rankMap.put(rank, name);
            playerMap.put(name, rank);
            
            rankMap.put(rank_tmp, i);
            playerMap.put(i, rank_tmp);
            
        }
        
        for(int i : rankMap.keySet()) {
            answer[i - 1] = rankMap.get(i);
        }
        
        return answer;
    }
}