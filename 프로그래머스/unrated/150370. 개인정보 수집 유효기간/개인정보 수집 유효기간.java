import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String i : terms) {
            StringTokenizer st = new StringTokenizer(i, " ");
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0; i<privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            String[] day = st.nextToken().split("\\.");
            String temp = st.nextToken();
            day[0] = String.valueOf(Integer.parseInt(day[0]) + (map.get(temp) / 12));
            day[1] = String.valueOf(Integer.parseInt(day[1]) + (map.get(temp) % 12 ));
            day[2] = String.valueOf(Integer.parseInt(day[2]) - 1);
            
            if(Integer.parseInt(day[1]) > 12) {
                day[0] = String.valueOf(Integer.parseInt(day[0]) + (Integer.parseInt(day[1]) / 12));
                day[1] = "0" + String.valueOf(Integer.parseInt(day[1]) % 12);
            } else if(Integer.parseInt(day[1]) < 10) {
                day[1] = "0" + day[1];
            }
            
            if(day[2].equals("0")) {
                day[1] = "0" + String.valueOf(Integer.parseInt(day[1]) - 1);
                day[2] = "28";
            } else if (Integer.parseInt(day[2]) < 10) {
                day[2] = "0" + Integer.parseInt(day[2]);
            }
            
            for(String j : day) {
                System.out.print(j + " ");
            }
            
            System.out.println();
            
            String[] today_arr = today.split("\\.");
            
            if(Integer.parseInt(today_arr[0]) > Integer.parseInt(day[0])) {
                answer.add(i+1);
            } else if(today_arr[0].equals(day[0])) {
                if(Integer.parseInt(today_arr[1]) > Integer.parseInt(day[1])) {
                    answer.add(i+1);
                } else if(today_arr[1].equals(day[1])) {
                    if(Integer.parseInt(today_arr[2]) > Integer.parseInt(day[2])) {
                        answer.add(i+1);
                    }
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}