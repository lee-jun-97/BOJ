import java.util.*;

class Solution {
    
    // 동, 서, 남, 북
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[] park, String[] routes) {
        
        Map<String, Integer> map = new HashMap<>();
        
        map.put("E", 0);
        map.put("W", 1);
        map.put("S", 2);
        map.put("N", 3);
        
        int x = 0, y = 0;       
        
        int w = park[0].length();
        int h = park.length;
        
        char[][] c_arr = new char[h][w];
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                char c = park[i].charAt(j);
                c_arr[i][j] = c;
                if(c == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for(String i : routes) {
            
            boolean isNext = true;
            
            String[] arr = i.split(" ");
            
            int idx = map.get(arr[0]);
            int nx = x;
            int ny = y;
            
            for(int j=0; j<Integer.parseInt(arr[1]); j++) {
                nx += dx[idx];
                ny += dy[idx];
                
                if(ny == w || nx == h || ny < 0 || nx < 0) {
                    isNext = false;
                    break;
                }
                
                if(c_arr[nx][ny] == 'X') {
                    isNext = false;
                    break;
                }
            }
            
            if(isNext) {
                x = nx;
                y = ny;
            }
        }
        return new int[] {x, y};
    }
}