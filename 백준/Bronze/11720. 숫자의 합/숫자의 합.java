import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        
        int result = 0;
        for(char c : input) {
            result += Character.getNumericValue(c);
        }
        
        System.out.println(result);
    }
}