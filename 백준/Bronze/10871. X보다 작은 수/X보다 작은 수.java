import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nx = br.readLine().split(" ");
        int n = Integer.parseInt(nx[0]);
        int x = Integer.parseInt(nx[1]);
        
        String[] input = br.readLine().split(" ");
        
        for(String i : input) {
            if(Integer.parseInt(i) < x) {
                System.out.print(i + " ");
            }
        }
    }
}