import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<10; i++) {
            String input = br.readLine();
            set.add(Integer.parseInt(input) % 42);
        }
        
        System.out.println(set.size());
    }
}