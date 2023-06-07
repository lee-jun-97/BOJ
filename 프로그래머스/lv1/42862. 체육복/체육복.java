import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        int[] cloth = new int[n + 1];
        
        for(int i : reserve) {
            cloth[i]++;
        }
        
        for(int i : lost) {
            if(cloth[i] != 0) {
                answer++;
            }
            cloth[i]--;
        }
        
        for(int i=0; i<cloth.length; i++) {
            if(cloth[i] == 1) {
                if(cloth[i - 1] == -1) {
                    cloth[i - 1]++;
                    cloth[i]--;
                    answer++;
                } else if(i + 1 < cloth.length && cloth[i + 1] == -1) {
                    cloth[i + 1]++;
                    cloth[i]--;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}