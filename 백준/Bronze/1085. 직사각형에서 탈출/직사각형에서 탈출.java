import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);
        
        int temp_1 = Math.min(Math.abs(x-w), Math.abs(y-h));
        int temp_2 = Math.min(Math.abs(x-0), Math.abs(y-0));
        
        System.out.println(Math.min(temp_1, temp_2));
    }
}