class Solution {
    
    public String solution(int n, int t, int m, int p) {
        int length = t*m;
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        
        while(true) {
            
            if(sb.length() >= length) {
                break;
            }
            sb.append(makeString(n, i));
            
            i++;
        }
        
        StringBuilder sb_result = new StringBuilder();
        
        int j=0;
        
        while(sb_result.length() < t) {
            sb_result.append(sb.toString().charAt(j+p-1));
            
            j+=m;
        }
        
        return sb_result.toString();
    }
    
    String makeString(int n, int num) {
     
        StringBuilder sb_2 = new StringBuilder();
            
        while(true) {
            if(num / n == 0) {
                if(num % n == 0) {
                    sb_2.append(num);
                } else {
                    if(num % n >= 10) {
                        char temp = (char)('A' + ((num % n) - 10));
                        sb_2.append(temp);
                    } else {
                        sb_2.append(num % n);
                    }
                }
                return sb_2.reverse().toString();
            }
            
            if(num % n >= 10) {
                char temp = (char)('A' + ((num % n) - 10));
                sb_2.append(temp);
            } else {
                sb_2.append(num % n);
            }
            num /= n;
        }
    }
}