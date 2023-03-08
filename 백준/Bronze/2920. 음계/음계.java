import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        boolean check = true;
        
        for(int i=0; i<input.length -1; i++) {
            if(Math.abs(Integer.parseInt(input[i]) - Integer.parseInt(input[i+1])) != 1) {
                check = false;
            }
        }
        
        if(check) {
            if(input[0].equals("1")) {
                System.out.println("ascending");
            } else {
                System.out.println("descending");
            }
        } else {
            System.out.println("mixed");
        }
    }
}