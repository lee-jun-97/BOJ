import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<String> deque = new LinkedList<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            String num = st.hasMoreTokens()?st.nextToken():"";

            if(cmd.equals("push_back")) {
                deque.addLast(num);
                continue;
            }

            if(cmd.equals("push_front")) {
                deque.addFirst(num);
                continue;
            }

            if(cmd.equals("pop_front")) {
                if(deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
                continue;
            }

            if(cmd.equals("pop_back")) {
                if(deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
                continue;
            }

            if(cmd.equals("size")) {
                sb.append(deque.size()).append("\n");
                continue;
            }

            if(cmd.equals("empty")) {
                if(deque.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                continue;
            }

            if(cmd.equals("front")) {
                if(deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
                continue;
            }

            if(cmd.equals("back")) {
                if(deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
                continue;
            }
        }

        System.out.println(sb.toString());
    }
}
