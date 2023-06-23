import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        
        int answer = 0;
        
        if(sticker.length <= 3) {
            for(int i : sticker) {
                answer = Math.max(answer, i);
            }
            return answer;
        }
                
        int[] sum = new int[sticker.length];
        int[] sum_2 = new int[sticker.length];
        
        sum[0] = sticker[0];
        sum[1] = sticker[0];
        sum_2[1] = sticker[1];
        
        for(int i=2; i<sticker.length; i++) {
            sum[i] = Math.max(sum[i-2] + sticker[i], sum[i-1]);
        }
        
        for(int i=2; i<sticker.length; i++) {
            sum_2[i] = Math.max(sum_2[i-2] + sticker[i], sum_2[i-1]);
        }
        
        return Math.max(sum[sum.length - 2], sum_2[sum_2.length - 1]);
    }
}