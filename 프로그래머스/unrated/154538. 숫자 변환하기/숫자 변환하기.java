import java.util.*;

class Solution {
    
    public class Node {
        int value;
        int cnt;
        
        public Node(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(y, 0));
        
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            
            if(temp.value % 3 == 0 && temp.value / 3 >= x) {
                queue.add(new Node(temp.value / 3, temp.cnt + 1));
            }
            
            if(temp.value % 2 == 0 && temp.value / 2 >= x) {
                queue.add(new Node(temp.value / 2, temp.cnt + 1));
            }
            
            if(temp.value - n >= x) {
                queue.add(new Node(temp.value - n, temp.cnt + 1));
            }
            
            if(temp.value == x) {
                answer = temp.cnt;
                break;
            }
        }
        return answer;
    }
}