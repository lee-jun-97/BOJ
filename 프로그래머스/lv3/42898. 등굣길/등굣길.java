import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        
        map[0][0] = 1;
        
        for(int[] i : puddles) {
            map[i[0] - 1][i[1] - 1] = -1;
        }
        
        for(int i=0; i<n; i++) {
            if(map[0][i] == -1) {
                break;
            }
            
            map[0][i] = 1;
        }
        
        for(int i=0; i<m; i++) {
            if(map[i][0] == -1) {
                break;
            }
            
            map[i][0] = 1;
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(map[i][j] == -1) {
                    continue;
                }
                
                if(map[i - 1][j] == -1) {
                    map[i][j] = map[i][j - 1] % 1000000007;
                } else if(map[i][j - 1] == -1) {
                    map[i][j] = map[i - 1][j] % 1000000007;
                } else {
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
                }
            }
        }
        
        return map[m - 1][n - 1];
    }
}