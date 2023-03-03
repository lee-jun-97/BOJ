import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {            
            String[] input = br.readLine().split(" ");
            int cnt = Integer.parseInt(input[0]);
            char[] str = input[1].toCharArray();
            
            for(int j=0; j<str.length; j++) {
                for(int k=0; k<cnt; k++) {
                    sb.append(str[j]);
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}