import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> s= new Stack<>();
        int n= prices.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&prices[s.peek()]>prices[i]){
                int index = s.pop();
                answer[index]=i-index;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int index=s.pop();
            answer[index]=n-1-index;
        }
        
        return answer;
    }
}