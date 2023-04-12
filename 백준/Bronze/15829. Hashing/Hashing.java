import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        BigDecimal sum = new BigDecimal(0);
        int r = 1;

        for(int i=0; i<n; i++) {
            sum = sum.add(new BigDecimal((str.charAt(i) - 'a' + 1) * r % 1234567891));
            r = (r*31) % 1234567891;
        }

        System.out.println(sum);
        
    }
}
