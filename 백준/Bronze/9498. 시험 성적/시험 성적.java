import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if(n >= 90) {
            System.out.println("A");
            System.exit(0);
        }
        
        if(n >= 90) {
            System.out.println("A");
            System.exit(0);
        }
        
        if(n >= 80 && n <= 89) {
            System.out.println("B");
            System.exit(0);
        }
        
        if(n >= 70 && n <= 79) {
            System.out.println("C");
            System.exit(0);
        }
        
        if(n >= 60 && n <= 69) {
            System.out.println("D");
            System.exit(0);
        }
        
        System.out.println("F");
    }
}