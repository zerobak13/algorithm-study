import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int count=1;
        Map<String,Integer>m=new HashMap<>();
        for(String[]x:clothes){
            m.put(x[1],m.getOrDefault(x[1],0)+1);
        }
        for(int v:m.values()){
            count*=v+1;
        }
        answer=count-1;
        return answer;
    }
}