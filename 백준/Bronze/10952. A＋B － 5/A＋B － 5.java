import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String temp = br.readLine();
            if(temp.equals("0 0")) {
                break;
            }
            
            String[] input = temp.split(" ");
            System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
        }
    }
}