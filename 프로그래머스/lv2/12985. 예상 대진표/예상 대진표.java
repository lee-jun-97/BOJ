class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        
        while(true) {
            
            if(Math.abs(a - b) == 1 && Math.max(a,b) % 2 == 0) {
                break;
            }
            
            if(a % 2 == 1) {
                a = (a + 1)/2;
            } else {
                a /= 2;
            }
            
            if(b % 2 == 1) {
                b = (b + 1)/2;
            } else {
                b /= 2;
            }
            
            answer++;
        }

        return answer;
    }
}