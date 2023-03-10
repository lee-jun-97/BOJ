import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visit = new boolean[n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0,0);

        System.out.println(result);

    }

    // 조합 알고리즘은 그냥 외우자
    static void combi(int idx, int cnt) {

        if(cnt == n/2) {
            diffCal();
            return ;
        }

        // 백트래킹 이용하기 위해 방문처리했던 index를 다시 비방문처리함.
        for(int i=idx; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combi(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }

    static void diffCal() {

        int start_score = 0;
        int link_score = 0;

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(visit[i] && visit[j]) {
                    start_score += arr[i][j];
                    start_score += arr[j][i];
                } else if(!visit[i] && !visit[j]) {
                    link_score += arr[i][j];
                    link_score += arr[j][i];
                }
            }
        }

        int temp = Math.abs(start_score - link_score);

        if(temp == 0) {
            System.out.println(temp);
            System.exit(0);
        }

        result = Math.min(result, temp);

    }
    
}
