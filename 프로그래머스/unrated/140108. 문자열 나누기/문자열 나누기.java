import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        // 결과 변수 선언
        int answer = 0;
        // 첫 번째 문자 지정.
        char c = ' ';
        // 첫 번째 문자의 갯수
        int first_num = 0;
        // 첫 번째 문자가 아닌 문자의 갯수
        int num = 0;
        
        // s의 길이 만큼 반복문
        for(int i=0; i<s.length(); i++) {
            
            if(c == ' ') {
                c = s.charAt(i);
                first_num++;
                continue;
            }
            
            if(c == s.charAt(i)) {
                first_num++;
                continue;
            } else {
                num++;
            }
            
            if(first_num == num) {
                answer++;
                first_num = 0;
                num = 0;
                c = ' ';
            }
        }
        
        if(c != ' ') {
            answer++;
        }
        
        return answer;
    }
}