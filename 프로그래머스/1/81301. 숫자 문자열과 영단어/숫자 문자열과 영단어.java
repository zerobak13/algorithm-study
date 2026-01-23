class Solution {
    public int solution(String s) {
        String[]words=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        int answer = 0;
        for(int i=0;i<10;i++){
            s=s.replace(words[i],String.valueOf(i));
        }
        answer=Integer.parseInt(s);
        return answer;
    }
}