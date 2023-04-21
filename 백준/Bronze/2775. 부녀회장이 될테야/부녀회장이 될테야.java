import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        int[][] apart = new int[15][15];


        for(int i=0; i<15; i++) {
            apart[0][i] = i;
            apart[i][1] = 1;
        }

        for(int i=1; i<15; i++) {
            for(int j=2; j<15; j++) {
                apart[i][j] = apart[i-1][j] + apart[i][j-1];
            }
        }

        for(int i=0; i<tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apart[k][n]).append("\n");
        }

        System.out.println(sb.toString());
        
    }
    
}
