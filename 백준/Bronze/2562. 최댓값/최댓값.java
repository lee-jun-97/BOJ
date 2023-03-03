import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        int idx = 0;
        
        for(int i=1; i<=9; i++) {
            int input = Integer.parseInt(br.readLine());
            max = Math.max(max, input);
            
            if(max == input) {
                idx = i;
            }
        }
        
        System.out.println(max);
        System.out.println(idx);
    }
}