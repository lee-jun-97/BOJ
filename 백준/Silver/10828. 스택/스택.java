import java.io.*;
import java.util.*;

public class Main {

    static Stack<String> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push" : stack.push(st.nextToken()); break;
                case "pop" :  pop(); break;
                case "size" : sb.append(stack.size()).append("\n"); break;
                case "empty" : isEmpty(); break;
                case "top" : top(); break;
            }
        }
        System.out.println(sb.toString());
    }

    public static void pop() {
        if(stack.isEmpty()) {
            sb.append("-1");
        } else {
            sb.append(stack.pop());
        }
        sb.append("\n");
    }

    public static void isEmpty() {
        if(stack.isEmpty()) {
            sb.append("1");
        } else {
            sb.append("0");
        }

        sb.append("\n");
    }

    public static void top() {
        if(stack.isEmpty()) {
            sb.append("-1");
        } else {
            sb.append(stack.peek());
        }
        
        sb.append("\n");
    }

}
