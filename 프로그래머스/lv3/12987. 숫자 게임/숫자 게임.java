import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int temp = 0;
        
        for(int i=0; i<A.length; i++) {
            for(int j=temp; j<B.length; j++) {
                if(A[i] < B[j]) {
                    B[j] = -1;
                    answer++;
                    temp = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}