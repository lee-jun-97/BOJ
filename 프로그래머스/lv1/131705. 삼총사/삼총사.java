class Solution {
    
    int answer = 0;
    boolean[] visited;
    
    public int solution(int[] number) {
        
        visited = new boolean[number.length];
        
        comb1(number, visited, 0, number.length, 3);
        
        return answer;
    }
    
    void comb1(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                if(visited[i] == true) {
                    sum += arr[i];
                }
            }
            
            if(sum == 0) {
                answer++;
            }
            return;
        } else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
	    }
    }
}