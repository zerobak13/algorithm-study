import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        //new int[]{2,1};
        int[]days=new int[speeds.length];
        for(int i=0;i<speeds.length;i++){
            int diff=100-progresses[i];
            int day=0;
            if(diff%speeds[i]==0){
                day=diff/speeds[i];
            }
            else{
                day=(diff/speeds[i])+1;
            }
            days[i]=day;
        }
//        for(int x:days){
//            System.out.println(x);
//        }
        int max=days[0];
        int count=1;
        List<Integer>l=new ArrayList<>();
        for(int i=1;i<speeds.length;i++){
            if (days[i] > max) {
                max = days[i];
                l.add(count);
                count=1;
                continue;
            }
            else{
                count++;

            }

        }
        l.add(count);
        answer=new int[l.size()];
        for(int i=0;i<l.size();i++){
            answer[i]=l.get(i);
        }


        return answer;
    }
}