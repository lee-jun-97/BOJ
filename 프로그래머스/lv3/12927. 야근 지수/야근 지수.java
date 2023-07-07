import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        });
        
        for(int i : works) {
            pq.add(i);
        }
        
        while(n > 0) {
            int temp = pq.poll();
            
            if(temp == 0) {
                break;
            }
            temp--;
            n--;
            
            pq.add(temp);
        }
        
        for(int i : pq) {
            answer += Math.pow(i, 2);
        }
//         int[] temp = new int[works.length];
//         int sum = 0;
        
//         for(int i : works) {
//             sum += i;
//         }
        
//         sum -= n;
        
//         if(sum <= 0) {
//             return 0;
//         }
        
//         int mod = sum / works.length;
//         int div = sum % works.length;
    
//         for(int i=0; i<works.length; i++) {
//             temp[i] = mod;
            
//             if(div > 0) {
//                 temp[i]++;
//                 div--;
//             }
//         }
        
//         for(int i : temp) {
//             answer += Math.pow(i, 2);
//         }
        
        return answer;
    }
}