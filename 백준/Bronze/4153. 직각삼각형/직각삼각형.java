import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String input = br.readLine();
            if(input.equals("0 0 0")) {
                break;
            }
            
            List<Integer> list = new ArrayList<>();
            for(String i : input.split(" ")) {
                list.add(Integer.parseInt(i));
            }
            
            Collections.sort(list);
            
            double sum = Math.pow(list.get(0), 2) + Math.pow(list.get(1),2);
            
            if(sum == Math.pow(list.get(2),2)) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}