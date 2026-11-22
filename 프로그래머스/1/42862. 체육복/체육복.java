class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int [] students = new int[n+1];
            //기본
            for(int i=1; i<=n; i++){
                students[i]=1;
            }
            //도난
            for(int i=0; i<lost.length; i++){
                students[lost[i]]--;
            }
            //여벌
            for(int i=0; i<reserve.length; i++){
                students[reserve[i]]++;
            }
//            for(int i=1; i<=n; i++){
//                System.out.print(students[i]+" ");
//            }
            //빌려주기
            for(int i=1; i<=n; i++){
                if(students[i]==0){
                    if(i-1>0&&students[i-1]>=2){
                        students[i-1]--;
                        students[i]++;
                    }
                    else if(i+1<n+1&&students[i+1]>=2){
                        students[i+1]--;
                        students[i]++;
                    }
                }
            }
            //System.out.println();
            //답 카운트
            for(int i=1; i<=n; i++){
                //System.out.print(students[i]+" ");
               if(students[i]>=1){
                   answer++;
               }
            }
            return answer;
        }
    }