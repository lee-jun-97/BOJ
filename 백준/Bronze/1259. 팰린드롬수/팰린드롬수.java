import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String input = br.readLine();

            if(input.equals("0")) {
                break;
            }
            
            StringBuilder temp = new StringBuilder();
            
            for(int i=input.length()-1; i>=0; i--) {
                temp.append(input.charAt(i));
            }
            
            if(input.equals(temp.toString())) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}