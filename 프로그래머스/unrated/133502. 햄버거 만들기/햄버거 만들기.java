import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : ingredient) {
            stack.push(i);
            
            if(stack.size() >= 4) {
                int temp = stack.pop();
                
                if(temp == 1) {
                    int temp_2 = stack.pop();
                    int temp_3 = stack.pop();
                    int temp_4 = stack.pop();
                    
                    if(temp_2 == 3 && temp_3 == 2 && temp_4 ==1) {
                        answer++;
                    } else {
                        stack.push(temp_4);
                        stack.push(temp_3);
                        stack.push(temp_2);
                        stack.push(temp);
                    }
                } else {
                    stack.push(temp);
                }
            }
        }
        return answer;
    }
}