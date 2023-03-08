import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            char[] input = br.readLine().toCharArray();
            
            int cnt = 1;
            int score = 0;
            for(char c : input) {
                if(c == 'O') {
                    score += cnt;
                    cnt++;
                } else {
                    cnt = 1;
                }
            }
            
            System.out.println(score);
        }
    }
}