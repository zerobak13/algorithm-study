import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int size=1;size<=s.length()/2;size++){
            StringBuilder sb=new StringBuilder();
            int count=1;
            String temp= s.substring(0,size);
            for(int j=size;j<=s.length();j+=size){
                String curr;
                if(j+size<=s.length()){
                    curr=s.substring(j,j+size);
                }
                else{
                    curr=s.substring(j);
                }
                if(temp.equals(curr)){
                    count++;
                }
                else{
                    if(count>1){
                        sb.append(count);
                    }
                    sb.append(temp);
                    temp=curr;
                    count=1;
                }
            }
            if(count>1){
                sb.append(count);
            }
            sb.append(temp);
            answer=Math.min(answer,sb.length());
        }


        return answer;
    }
}