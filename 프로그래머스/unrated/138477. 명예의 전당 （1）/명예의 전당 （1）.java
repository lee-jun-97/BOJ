import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        
        for(int i=0; i<score.length; i++) {
            pQueue.add(score[i]);
            
            if(pQueue.size() > k) {
                pQueue.poll();
            }
            
            answer[i] = pQueue.peek();
        }
        
        return answer;
    }
}