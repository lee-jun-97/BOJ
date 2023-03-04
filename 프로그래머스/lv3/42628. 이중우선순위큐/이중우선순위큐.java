import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        
        PriorityQueue<Integer> tempQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1 - e2;
            }
        });
        
        for(String i : operations) {
            String[] temp = i.split(" ");
            
            if(temp[0].equals("I")) {
                pQ.add(Integer.parseInt(temp[1]));
                continue;
            }
            
            if(temp[0].equals("D")) {
                if(pQ.size() == 0) {
                    continue;
                }
                
                if(temp[1].equals("-1")) {
                    pQ.poll();
                } else {
                    while(pQ.size() != 1) {
                        tempQ.add(pQ.poll());
                    }
                    pQ.poll();
                    while(!tempQ.isEmpty()) {
                        pQ.add(tempQ.poll());
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        
        if(pQ.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[1] = pQ.poll();
            while(pQ.size() != 1) {
                pQ.poll();
            }
            answer[0] = pQ.poll();
        }
        
        
        return answer;
    }
}