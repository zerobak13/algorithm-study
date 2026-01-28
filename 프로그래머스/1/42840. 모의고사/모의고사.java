import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[]a=new int[]{1,2,3,4,5};//5
        int[]b=new int[]{2,1,2,3,2,4,2,5};//8
        int[]c=new int[]{3,3,1,1,2,2,4,4,5,5};//10
        int ac=0;
        int bc=0;
        int cc=0;
        for(int i=0;i<answers.length;i++) {
            if(a[i%5]==answers[i]){
                ac++;
            }
            if(b[i%8]==answers[i]){
                bc++;
            }
            if(c[i%10]==answers[i]){
                cc++;
            }
        }
        int max= Math.max(ac,Math.max(bc,cc));
        List<Integer>l=new ArrayList<>();
        if(max==ac){
           l.add(1);
        }
        if(max==bc){
            l.add(2);
        }
        if(max==cc){
            l.add(3);
        }
        int []answer=new int[l.size()];
        for(int i=0;i<l.size();i++){
            answer[i]=l.get(i);
        }

        return answer;
    }
}

