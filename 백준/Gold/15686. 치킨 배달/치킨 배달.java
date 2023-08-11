import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Node> house = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        List<Node> chicken = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    house.add(new Node(i, j));
                } else if(map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        combi(chicken, new boolean[chicken.size()], 0, chicken.size(), m);
        System.out.println(answer);
        
    }

    static void combi(List<Node> list, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            cal(list, visited, n);
            return ;
        }

        for(int i=start; i<n; i++) {
            visited[i] =true;
            combi(list, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void cal(List<Node> list, boolean[] visited, int n) {

        int dis = 0;

        for(Node node : house) {
            int dis_temp = Integer.MAX_VALUE;
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    Node ck = list.get(i);

                    int x = Math.abs(node.x - ck.x);
                    int y = Math.abs(node.y - ck.y);

                    dis_temp = Math.min(dis_temp, x + y);
                }
            }

            dis += dis_temp;
        }

        answer = Math.min(answer, dis);
    }
}
