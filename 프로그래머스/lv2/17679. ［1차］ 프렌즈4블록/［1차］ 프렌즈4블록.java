import java.util.*;

class Solution {
    
    int answer = 0;
    
    int[] dx = { 0, 1, 1 };
    int[] dy = { 1, 0, 1 };
    
    boolean[][] visited ;
    
    public class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int m, int n, String[] board) {

        List<List<Character>> list = new ArrayList<>();
        
        for(int i=0; i<board[0].length(); i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                list.get(j).add(0, board[i].charAt(j));
            }
        }
        
        recursion(m, n, list);
        
        return answer;
    }
    
    void recursion(int m, int n, List<List<Character>> list) {
        
        int break_block = 0;
        visited = new boolean[n][m];
        
        Queue<Node> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                boolean check = true;
                char temp = list.get(i).get(j);
                for(int k=0; k<3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    
                    if(nx < n && list.get(nx).size() > ny) {
                        if(temp != list.get(nx).get(ny)) {
                            check = false;
                            break;
                        } else {
                            queue.add(new Node(nx, ny));
                        }    
                    } else {
                        check = false;
                        break;
                    }
                }
                
                if(check) {
                    while(!queue.isEmpty()) {
                        Node node = queue.poll();
                        visited[node.x][node.y] = true;
                    }
                    visited[i][j] = true;
                } else {
                    queue.clear();
                }
            }
        }
        
        
        for(int i=0; i<visited.length; i++) {
            for(int j=visited[0].length - 1; j>=0; j--) {
                if(visited[i][j]) {
                    list.get(i).remove(j);
                    break_block++;
                }
            }
        }
        
        if(break_block == 0) {
            return ;
        } else {
            answer += break_block;
            recursion(m, n, list);
        }
        
    }
}