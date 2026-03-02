import java.util.*;

class Solution {
    static boolean[]visited;
    static List<String>path;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited=new boolean[tickets.length];
        path=new ArrayList<>();
        
        Arrays.sort(tickets,(a,b)->{
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            else{
                return a[0].compareTo(b[0]);
            }
        });
        
        path.add("ICN");
        
        dfs("ICN",tickets,0);        
        answer=path.toArray(new String[0]);
        
        return answer;
    }
    
    static boolean dfs(String curr,String[][]tickets,int depth){
        if(depth==tickets.length){
            return true;
        }
        for(int i=0;i<tickets.length;i++){
            if(!visited[i]&&tickets[i][0].equals(curr)){
                visited[i]=true;
                path.add(tickets[i][1]);
                if(dfs(tickets[i][1],tickets,depth+1)){
                    return true;
                };
                visited[i]=false;
                path.remove(path.size()-1);  
            }
        }
        
        return false;
    }
    
    
}