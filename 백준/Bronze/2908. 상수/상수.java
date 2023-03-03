import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        for(int i=0; i<input.length; i++) {
            StringBuilder sb = new StringBuilder();

            sb.append(input[i].charAt(2));
            sb.append(input[i].charAt(1));
            sb.append(input[i].charAt(0));
            
            input[i] = sb.toString();
        }
        
        System.out.println(Math.max(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
    }
}