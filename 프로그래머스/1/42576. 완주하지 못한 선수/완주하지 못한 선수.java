
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer>map=new HashMap<>();
        for(String x:participant){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(String y:completion){
           map.put(y, map.get(y)-1);
        }
        for(String k:map.keySet()){
            if(map.get(k)>0){
                answer=k;
            }
        }
        
        return answer;
    }
}