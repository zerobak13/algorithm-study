import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[]num=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            num[i]=String.valueOf(numbers[i]);
        }
        //음수면 a가 앞  30_3   3_30
        Arrays.sort(num,(a,b)->(b+a).compareTo(a+b));
        
        if(num[0].equals("0")){
            return "0";
        }
        StringBuilder sb= new StringBuilder();
        for(String x:num){
            sb.append(x);
        }
        answer=sb.toString();
        
        
        return answer;
    }
}