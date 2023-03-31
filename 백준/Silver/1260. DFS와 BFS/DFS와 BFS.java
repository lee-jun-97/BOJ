import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static boolean[] arr;
    static Queue<Integer> queue;

    static int nodeCnt;
    static int lineCnt;
    static int rootNode;
    static int[][] nodeTree;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        nodeCnt = Integer.parseInt(input[0]);
        lineCnt = Integer.parseInt(input[1]);
        rootNode = Integer.parseInt(input[2]);
        nodeTree = new int[nodeCnt+1][nodeCnt+1];

        arr = new boolean[nodeCnt+1];

        for(int i=0; i<lineCnt; i++) {
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            nodeTree[x][y] = nodeTree[y][x] = 1;
            
        }

        dfs(rootNode);
        sb.append("\n");

        Arrays.fill(arr, false);

        bfs(rootNode);

        System.out.println(sb.toString());


    }

    public static void dfs(int root) {

        arr[root] = true;

        sb.append(root + " ");

        for(int i=1; i<=nodeCnt; i++) {
            if(nodeTree[root][i] == 1 && arr[i] == false) {
                dfs(i);
            }
        }

    }

    public static void bfs(int root) {

        queue = new LinkedList<>();
        queue.add(root);

        arr[root] = true;

        sb.append(root + " ");

        while(!queue.isEmpty()) {

            int temp = queue.poll();

            for(int i=1; i<nodeTree.length; i++){
                if(nodeTree[temp][i] == 1 && arr[i] == false) {
                    queue.add(i);
                    arr[i] = true;
                    sb.append(i + " ");
                }
            }
        }

    }
}
