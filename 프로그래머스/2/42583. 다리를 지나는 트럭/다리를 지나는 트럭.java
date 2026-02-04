import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curr_weight=0;
        Queue<Integer>bridge=new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            bridge.add(0);
        }
        int index=0;
        int time=0;
        while(index<truck_weights.length){
            time++;
            curr_weight -= bridge.poll();

            if(curr_weight+truck_weights[index]<=weight) {
                curr_weight+=truck_weights[index];
                bridge.add(truck_weights[index]);
                index++;
            }
            else{bridge.add(0);
            }




        }


        answer=time+bridge_length;


        return answer;
    }
}