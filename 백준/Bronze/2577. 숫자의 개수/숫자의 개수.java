import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int number = 1;
        
        for(int i=0; i<3; i++) {
            number *= Integer.parseInt(br.readLine());
        }
        
        char[] arr = String.valueOf(number).toCharArray();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(char c : arr){
            int temp = Character.getNumericValue(c);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        
        for(int i=0; i<=9; i++) {
            System.out.println(map.get(i)==null?0:map.get(i));
        }
    }
}