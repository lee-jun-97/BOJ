class Solution {
    
    int answer = 0;
    
    public int solution(int a, int b, int n) {
        recursion(a, b, n);        
        return answer;
    }
    
    void recursion(int a, int b, int n) {
        
        if(n < a) {
            return;
        }
        
        int cola = (n / a) * b;
        int mod = n % a;
        
        int next = cola + mod;
        
        answer += cola;
        
        recursion(a, b, next);
    }
}