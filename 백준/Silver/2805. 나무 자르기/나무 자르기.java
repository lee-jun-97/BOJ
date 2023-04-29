import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        
        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            if(max < temp) {
                max = temp;
            }
        }

        while(min < max) {

            long sum = 0;

            int mid = (max + min) / 2;

            for(int i : arr) {
                if(i > mid) {
                    sum += (i - mid);
                }
            }

            if(sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}
