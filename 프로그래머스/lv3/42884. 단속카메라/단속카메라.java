import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        int camera = -30001;

        Arrays.sort(routes, new Comparator<>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                return e1[1] - e2[1];
            }
        });

        for(int i=0; i<routes.length; i++) {
            if(camera < routes[i][0]) {
                answer++;
                camera = routes[i][1];
            }
        }
        
        return answer;
    }
}