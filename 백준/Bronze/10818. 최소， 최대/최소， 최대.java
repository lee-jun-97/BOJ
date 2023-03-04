import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] input = br.readLine().split(" ");
        
        for(String i : input) {
            max = Math.max(max, Integer.parseInt(i));
            min = Math.min(min, Integer.parseInt(i));
        }
        
        System.out.println(min + " " + max);
    }
}