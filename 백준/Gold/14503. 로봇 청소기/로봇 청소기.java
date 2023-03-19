import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    // 이동 방향 북, 동, 남, 서
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    static int count, N, M;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        
        clean(r, c, d);

        System.out.println(count);

    }

    public static void clean(int r, int c, int d) {

        map[r][c] = -1;

        for(int i=0; i<4; i++) {

            d = (d + 3) % 4;

            int nY = r + dy[d];
            int nX = c + dx[d];
            
            if(nX >= 0 && nY >= 0 && nX < M && nY < N && map[nY][nX] == 0) {
                    count++;
                    clean(nY, nX, d);

                    return;
            }

        }
        
        int temp = (d + 2) % 4;

        int nY = r + dy[temp];
        int nX = c + dx[temp];

        if(nX >= 0 && nY >= 0 && nX < M && nY < N && map[nY][nX] != 1) {
            clean(nY, nX, d);
        } 

    }
}
