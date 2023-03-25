class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        boolean[] paint = new boolean[n+1];
        
        for(int i : section) {
            paint[i] = true;
        }
        
        for(int i=1; i<paint.length; i++) {
            if(paint[i]) {
                
                if(i+m > n) {
                    answer++;
                    break;
                }
                
                for(int j=i; j<i+m; j++) {
                    paint[j] = false;
                }
                answer++;
            }
        }
        return answer;
    }
}