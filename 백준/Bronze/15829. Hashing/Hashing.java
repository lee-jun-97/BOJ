import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0;

        for(int i=0; i<n; i++) {
            sum += (str.charAt(i) - 'a' + 1) * Math.pow(31, i);
        }

        System.out.println(sum);
        
    }
}
