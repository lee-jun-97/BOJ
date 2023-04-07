import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());

        int main = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        long result = 0;

        result += n;

        for(int i : arr) {
            i -= main;

            if( i > 0) {
                result += ( i / sub );
                
                if(i % sub != 0) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
