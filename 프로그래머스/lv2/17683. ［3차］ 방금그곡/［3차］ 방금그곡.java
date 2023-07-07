import java.util.*;

class Solution {
    
    public class Node {
        String song_title;
        int song_length;
        
        public Node(String song_title, int song_length) {
            this.song_title = song_title;
            this.song_length = song_length;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        List<Node> result = new ArrayList<>();
        Map<String, String> melody = new HashMap<>();
        
        melody.put("A#", "H");
        melody.put("C#", "J");
        melody.put("D#", "K");
        melody.put("F#", "L");
        melody.put("G#", "M");
        melody.put("E#", "N");
        
        List<String> list = new ArrayList<>();
        
        list.add("A#");
        list.add("C#");
        list.add("D#");
        list.add("E#");
        list.add("F#");
        list.add("G#");
        list.add("E#");
        
        for(String str : musicinfos) {
            String[] temp = str.split(",");
            
            String[] start = temp[0].split(":");
            int start_hour = Integer.parseInt(start[0]);
            int start_min = Integer.parseInt(start[1]);
            
            String[] end = temp[1].split(":");
            int end_hour = Integer.parseInt(end[0]);
            int end_min = Integer.parseInt(end[1]);
            
            String title = temp[2];
            String song = temp[3];
            
            int length = 0;
            if(end_min - start_min < 0) {
                length += 60 - start_min + end_min;
                length += 60 * (end_hour - start_hour - 1);
            } else {
                length += (end_min - start_min);
                length += 60 * (end_hour - start_hour);
            }
            
            for(String str2 : list) {
                if(song.contains(str2)) {
                    song = song.replace(str2, melody.get(str2));
                }
                
                if(m.contains(str2)) {
                    m = m.replace(str2, melody.get(str2));
                }
            }
            
            if(length > song.length()) {
                while(song.length() <= length) {
                    song = song.concat(song);
                }
            }
            
            song = song.substring(0, length);
            
            if(song.contains(m)) {
                result.add(new Node(title, length));
            }
        }
        
        if(result.size() == 0) {
            return "(None)";
        }
        
        int max = 0;

        for(Node node : result) {
            
            int temp = node.song_length;
            
            if(temp == max) {
                continue;
            }
            
            if(temp > max) {
                max = temp;
                answer = node.song_title;
            }
        }
        
        return answer;
    }
}