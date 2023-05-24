import java.util.*;

class Solution {
    
    public class Node {
        int idx;
        int value;
        
        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Node> stack = new Stack<>();
        
        stack.push(new Node(0, numbers[0]));
        answer[0] = -1;
        
        for(int i=1; i<numbers.length; i++) {
            answer[i] = -1;
            while(!stack.isEmpty() && stack.peek().value < numbers[i]) {
                Node temp = stack.pop();
                answer[temp.idx] = numbers[i];
            }
            
            stack.push(new Node(i, numbers[i]));
        }
        
        return answer;
    }
}