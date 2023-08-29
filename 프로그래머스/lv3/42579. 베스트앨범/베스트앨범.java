import java.util.*;

class Solution {
    
    public class Node {
        String genre;
        int play;
        
        public Node(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
    }
    
    public class Node_idx {
        int idx;
        int play;
        
        public Node_idx(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Node e1, Node e2) {
                return e2.play - e1.play;
            }
        });
        
        for(String i : map.keySet()) {
            pq.add(new Node(i, map.get(i)));
        }
        
        int idx = 0;
        
        List<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            
            List<Node_idx> list = new ArrayList<>();
            
            for(int i=0; i<genres.length; i++) {
                if(genres[i].equals(temp.genre)) {
                    list.add(new Node_idx(i, plays[i]));
                }
            }
            
            Collections.sort(list, new Comparator<>() {
                @Override
                public int compare(Node_idx e1, Node_idx e2) {
                    if(e1.play == e2.play) {
                        return e1.idx - e2.idx;
                    } else {
                        return e2.play - e1.play;
                    }
                }
            });
            
            if(list.size() >= 2) {
                result.add(list.get(0).idx);
                result.add(list.get(1).idx);
            } else {
                result.add(list.get(0).idx);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}