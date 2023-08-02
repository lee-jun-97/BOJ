class Solution {
    
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        map = new int[rows][columns];
        
        int cnt = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = cnt;
                cnt++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            answer[i] = rotate(x1, y1, x2, y2);
        }
        
        return answer;
    }
    
    int rotate(int x1, int y1, int x2, int y2) {
        
        int result = Integer.MAX_VALUE;
        
        int temp = map[x1][y1];
        
        for(int i=x1; i<x2; i++) {
            map[i][y1] = map[i + 1][y1];
            result = Math.min(result, map[i][y1]);
        }
        
        for(int i=y1; i<y2; i++) {
            map[x2][i] = map[x2][i + 1];
            result = Math.min(result, map[x2][i]);
        }
        
        for(int i=x2; i>x1; i--) {
            map[i][y2] = map[i - 1][y2];
            result = Math.min(result, map[i][y2]);
        }
        
        for(int i=y2; i>y1; i--) {
            map[x1][i] = map[x1][i - 1];
            result = Math.min(result, map[x1][i]);
        }
        
        map[x1][y1 + 1] = temp;
        result = Math.min(result, temp);
        
        return result;
    }
}