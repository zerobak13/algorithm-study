import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{0, 0});
        map.put(4, new int[]{1, 0});
        map.put(7, new int[]{2, 0});

        map.put(3, new int[]{0, 2});
        map.put(6, new int[]{1, 2});
        map.put(9, new int[]{2, 2});

        map.put(2, new int[]{0, 1});
        map.put(5, new int[]{1, 1});
        map.put(8, new int[]{2, 1});
        map.put(0, new int[]{3, 1});

        StringBuilder sb = new StringBuilder();
        int rX=3, rY=2;
        int lX=3, lY=0;
        for (int i = 0; i < numbers.length; i++) {
            int[] cur = map.get(numbers[i]);

            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                lX=cur[0];
                lY=cur[1];

            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                rX=cur[0];
                rY=cur[1];
            } else {
                if((Math.abs(rX - cur[0]) + Math.abs(rY - cur[1]))>(Math.abs(lX - cur[0]) + Math.abs(lY - cur[1]))){
                    sb.append("L");
                    lX=cur[0];
                    lY=cur[1];
                }
                else if((Math.abs(rX - cur[0]) + Math.abs(rY - cur[1]))<(Math.abs(lX - cur[0]) + Math.abs(lY - cur[1]))){
                    sb.append("R");
                    rX=cur[0];
                    rY=cur[1];
                }
                else{
                    if(hand.equals("right")) {
                        sb.append("R");
                        rX=cur[0];
                        rY=cur[1];
                    }
                    else{
                        sb.append("L");
                        lX=cur[0];
                        lY=cur[1];
                    }
                }
            }


        }
        answer=sb.toString();
        return answer;
    }
}

