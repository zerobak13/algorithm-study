import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Deque<Character>d=new ArrayDeque<>();
        d.addLast(number.charAt(0));
        for(int i=1;i<number.length();i++){
            char curr=number.charAt(i);
            while(!d.isEmpty()&&k>0&&d.peekLast()<curr){
                d.pollLast();
                k--;
            }
            d.addLast(curr);
        }
        while(k>0){
            d.pollLast();
            k--;
        }
        StringBuilder sb= new StringBuilder();
        for(char x:d){
            sb.append(x);
        }
        answer=sb.toString();
        
        return answer;
    }
}