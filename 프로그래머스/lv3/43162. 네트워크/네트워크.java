import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.add(0); 
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            
            for(int i=0; i<n; i++) {
                if(!visited[i] && computers[temp][i] == 1 && temp != i) {
                    queue.add(i);
                }
            }
        }
        
        answer++;
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                queue.add(i);
                
                while(!queue.isEmpty()) {
                    int temp = queue.poll();
                    visited[temp] = true;

                    for(int j=0; j<n; j++) {
                        if(!visited[j] && computers[temp][j] == 1 && temp != j) {
                            queue.add(j);
                        }
                    }
                }
                
                answer++;
            }
        }
        
        
        return answer;
    }
}