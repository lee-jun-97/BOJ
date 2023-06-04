import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int size = elements.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<=size; j++) {
                int sum = 0;
                for(int k=0; k<j; k++) {
                    sum += elements[(i+k)%size];
                }
                if(sum != 0) {
                    set.add(sum);
                }
            }
        }
        
        return set.size();
    }
}