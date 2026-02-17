import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n=people.length;
        int right=n-1;
        int left=0;
        
        Arrays.sort(people);
        
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
                right--;
            }
            else{
               right--;
            }
             answer++;
        }
        
        return answer;
    }
}