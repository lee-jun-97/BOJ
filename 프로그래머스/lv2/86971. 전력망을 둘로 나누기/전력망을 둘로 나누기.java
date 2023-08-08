import java.util.*;

class Solution {
    
    boolean[][] map;
    
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
         map = new boolean[n+1][n+1];

        for(int[] i : wires) {
            map[i[0]][i[1]] = true;
            map[i[1]][i[0]] = true;
        }
        
        for(int[] i : wires) {
            map[i[0]][i[1]] = false;
            map[i[1]][i[0]] = false;
            
            boolean[] visited = new boolean[n + 1];
            
            answer = Math.min(answer, countNode(visited, n));
            
            map[i[0]][i[1]] = true;
            map[i[1]][i[0]] = true;
        }
        
        return answer;
    }
    
    int countNode(boolean[] visited, int n) {
        
        int cnt1 = 1;
        int cnt2 = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            
            visited[temp] = true;
            for(int i=1; i<=n; i++) {
                if(!visited[i] && map[temp][i]) {
                    queue.add(i);
                    cnt1++;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                queue.add(i);
                break;
            }
        }
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            
            visited[temp] = true;
            for(int i=1; i<=n; i++) {
                if(!visited[i] && map[temp][i]) {
                    queue.add(i);
                    cnt2++;
                }
            }
        }
        
        return Math.abs(cnt1 - cnt2);
    }
}