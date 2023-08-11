import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<String> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split(" ");

        combi(input, new boolean[c], 0, c, l);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(String i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void combi(String[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            check(arr, visited, n);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combi(arr, visited, i + 1, n , r - 1);
            visited[i] = false;
        }
    }

    static void check(String[] arr, boolean[] visited, int n) {

        List<String> temp = new ArrayList<>();

        int mo = 0;
        int ja = 0;

        for(int i=0; i<n; i++) {
            if(visited[i]) {
                temp.add(arr[i]);
                if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                    mo++;
                } else {
                    ja++;
                }
            }
        }

        if(mo >= 1 && ja >= 2) {
            String result = " ";
            Collections.sort(temp);
            for(String i : temp) {
                result = result.concat(i);
            }
            result = result.trim();
            list.add(result);
        }
    }
}
