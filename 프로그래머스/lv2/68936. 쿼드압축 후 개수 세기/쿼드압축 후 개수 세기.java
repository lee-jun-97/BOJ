class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        recursion(0,0, arr.length, arr[0].length, arr);
        
        return answer;
    }
    
    void recursion(int x, int y, int max_x, int max_y, int[][] arr) {
        
        if(x == max_x || y == max_y || Math.abs(max_x - x) == 1 || Math.abs(max_y - y) == 1) {
            answer[arr[x][y]]++;
            return;
        }
        
        int first_num = arr[x][y];
        boolean check = true;
        
        for(int i=x; i<max_x; i++) {
            for(int j=y; j<max_y; j++) {
                if(first_num != arr[i][j]) {
                    check = false;
                    break;
                }
            }
            
            if(!check) {
                break;
            }
        }
        
        
        
        if(!check) {
            recursion(x, (y+max_y) / 2, (x+max_x)/2, max_y, arr);
            recursion(x, y, (x+max_x) / 2, (y+max_y) / 2, arr);
            recursion((x+max_x) / 2, y, max_x, (y+max_y) / 2, arr);
            recursion((x+max_x) / 2, (y+max_y) / 2, max_x, max_y, arr);
        }  else {
            answer[first_num]++;
            return;
        }
        
    }
}