import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // 굳이 0을 돌리고 다시 탐색할 필요 없이 방문배열 이용하여 한번에 해결하도록 수정.
        // queue.add(0); 
        // while(!queue.isEmpty()) {
        //     int temp = queue.poll();
        //     visited[temp] = true;
            
        //     for(int i=0; i<n; i++) {
        //         if(!visited[i] && computers[temp][i] == 1 && temp != i) {
        //             queue.add(i);
        //         }
        //     }
        // }
        
        // answer++;
        
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
