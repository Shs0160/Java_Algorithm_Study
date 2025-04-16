import java.util.*;
import java.lang.*;

class Solution {
    
    /*
    DFS - 백트래킹
    */
    
    List<String> ans = new ArrayList<>();
    List<String> result = null;
        
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        
        sortTickets(tickets);
        
        ans.add("ICN");
        dfs(0, visited, "ICN", tickets);
        return result.toArray(new String[0]);
    }
    
    public boolean dfs(int index, boolean[] visited, String now, String[][] tickets) {
        if (index == tickets.length) {
            result = new ArrayList<>(ans); 
            return true;  
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                ans.add(tickets[i][1]);

                if (dfs(index + 1, visited, tickets[i][1], tickets)) return true;

                visited[i] = false;
                ans.remove(ans.size() - 1);  
            }
        }

        return false;
    }
    
    public void sortTickets(String[][] tickets) {
        int n = tickets.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (compare(tickets[j], tickets[min]) < 0) {
                    min = j;
                }
            }
            
            String[] temp = tickets[i];
            tickets[i] = tickets[min];
            tickets[min] = temp;
        }
    }

    public int compare(String[] a, String[] b) {
        if (a[0].equals(b[0])) {
            return a[1].compareTo(b[1]);
        } else {
            return a[0].compareTo(b[0]);
        }
    }
  
}
