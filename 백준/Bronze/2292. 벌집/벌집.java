import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int circle = 1;
        int result = 1;
        while(true) {
            if(circle >= n) {
                break;
            }
            circle += (6 * result);
            result++;
        }
        
        System.out.println(result);
    }
}