import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        
        for(String i : cards1) {
            queue1.add(i);
        }
        
        for(String i : cards2) {
            queue2.add(i);
        }
        
        String answer = "Yes";
        
        for(String i : goal) {
            if(!queue1.isEmpty() && queue1.peek().equals(i)) {
                queue1.poll();
            } else if(!queue2.isEmpty() && queue2.peek().equals(i)) {
                queue2.poll();
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}