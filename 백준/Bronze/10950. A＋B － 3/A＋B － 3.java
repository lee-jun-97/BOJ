import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            
            System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
        }
    }
}