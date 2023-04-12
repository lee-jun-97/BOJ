import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int first = 0;
            int last = 0;

            if(n % h == 0) {
                first = h;
                last = n / h;
            } else {
                first = n % h;
                last = (n / h) + 1;
            }


            sb.append((first*100) + last).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}
