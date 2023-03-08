import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(arr, Collections.reverseOrder());
        
        int result = 0;
        
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    int sum = arr.get(i) + arr.get(j) + arr.get(k);
                    if(sum <= m) {
                        result = Math.max(result, sum);
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}