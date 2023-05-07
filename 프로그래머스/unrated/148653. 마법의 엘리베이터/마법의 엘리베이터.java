import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int storey) {
        recursion(storey);
        return answer;
    }
    
    void recursion(int n) {
        
        if(n == 0) {
            return;
        }
        
        int temp = n % 10;
        int next_value = n / 10;
        
        if(temp > 5) {
            answer += (10 - temp);
            next_value++;
        } else if(temp == 5) {
            if(next_value % 10 >= 5) {
                next_value++;
            }
            
            answer += temp;
        } else {
            answer += temp;
        }
        
        recursion(next_value);
    }
}