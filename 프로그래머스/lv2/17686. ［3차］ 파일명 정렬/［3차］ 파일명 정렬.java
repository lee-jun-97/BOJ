import java.util.*;

class Solution {
    
    public class Node {
        String head;
        String number;
        String str;
        
        public Node(String head, String number, String str) {
            this.head = head;
            this.number = number;
            this.str = str;
        }
    }
    
    public String[] solution(String[] files) {
        Node[] arr = new Node[files.length];
        
        for(int i=0; i<files.length; i++) {
            String head = "";
            String number = "";
            int idx = 0;
            int num_end_idx = 0;
            boolean isNumStart = true;
            for(int j=0; j<files[i].length(); j++) {
                char temp = files[i].charAt(j);
                if(Character.isDigit(temp)) {
                    if(isNumStart) { 
                        head = files[i].substring(0, j);
                        idx = j;
                        isNumStart = false;
                    } else {
                        num_end_idx++;
                        if(num_end_idx == 4) {
                            break;
                        }
                    }
                } else {
                    if(!isNumStart) {
                        break;
                    }
                }
            }
            
            number = files[i].substring(idx, idx + num_end_idx + 1);
            arr[i]= new Node(head, number ,files[i]);
        }
        
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Node e1, Node e2) {
                if(e1.head.compareToIgnoreCase(e2.head) == 0) {
                    return Integer.parseInt(e1.number) - Integer.parseInt(e2.number);
                } else {
                    return e1.head.compareToIgnoreCase(e2.head.toLowerCase());
                }
            }
        });
        
        String[] answer = new String[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            answer[i] = arr[i].str;
        }
        return answer;
    }
}