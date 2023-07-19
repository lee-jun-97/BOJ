import java.util.*;

class Solution {
    
    public class Node {
        String s;
        int count;
        boolean[] visited;
        
        public Node(String s, int count, boolean[] visited) {
            this.s = s;
            this.count = count;
            this.visited = visited;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean check = false;
        for(String s : words) {
            if(s.equals(target)) {
                check = true;
            }
        }
        
        if(!check) {
            return 0;
        }
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(begin, 0, visited));
        
        while(!q.isEmpty()) {
            
            Node node = q.poll();
            
            if(node.s.equals(target)) {
                answer = node.count;
                break;
            }
            
            char[] arr = node.s.toCharArray();
            
            for(int i=0; i<begin.length(); i++) {
                char temp = arr[i];
                arr[i] = '.';
                
                for(int j=0; j<words.length; j++) {
                    String s = String.valueOf(arr);

                    if(!node.visited[j] && words[j].matches(s)) {
                        node.visited[j] = true;
                        q.add(new Node(words[j], node.count + 1, node.visited));
                        // BFS 진행 시 다시 되돌아갈 필요가 없어서 필요가 없는 걸까 ?
                        // node.visited[j] = false;
                    }
                }
                
                arr[i] = temp;
            }
        }
        
        return answer;
    }
}