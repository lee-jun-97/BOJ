import java.util.*;

class Solution {
    
    boolean[] visited;
    
    Set<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        for(int i=0; i<banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        
        combi(0, user_id, banned_id, "");
        
        return set.size();
    }
    
    void combi(int idx, String[] user, String[] ban, String str) {
        if(idx == ban.length) {
            String[] result = str.split(" ");
            
            Arrays.sort(result);
            
            String temp = result[0];
            
            for(int i=1; i<result.length; i++) {
                temp = temp.concat(result[i]);
            }
            
            set.add(temp);
            
            return;
        }
        
        for(int i=0; i<user.length; i++) {
            if(!visited[i] && user[i].matches(ban[idx])) {
                visited[i] = true;
                combi(idx + 1, user, ban, str.concat(user[i]).concat(" "));
                visited[i] = false;
            }
        }
        
    }
}