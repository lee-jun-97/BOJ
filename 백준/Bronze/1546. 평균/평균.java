import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double max = 0;

        double[] arr = new double[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        for(int i=0; i<n; i++) {
            arr[i] /= max;
            arr[i] *= 100;
        }
        
        double result = 0;
        for(int i=0; i<n; i++) {
            result += arr[i];
        }
        
        System.out.println(result/n);
        
    }

}
