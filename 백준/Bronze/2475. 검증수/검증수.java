import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int result = 0;
        
        for(String i : input) {
            int temp = Integer.parseInt(i);
            result += temp * temp;
        }
        
        System.out.println(result % 10);
    }
}