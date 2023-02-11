import java.io.*;
import java.util.*;

class Solution {
    // start 19:00
    
    HashMap<String, Integer> reportCounter = new HashMap<>();
    HashMap<String, HashSet<String>> reportTable = new HashMap<>();
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        setReportTable(report);
        // printReportTable();
        setReportCounter();
        setAnswer(answer, id_list, k);
        
        
        return answer;
    }
    
    private void setReportTable(String[] report) {
        for(int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String reporter = st.nextToken();
            String reportedPerson = st.nextToken();
            
            HashSet<String> set = reportTable.getOrDefault(reporter, new HashSet<String>());
            set.add(reportedPerson);
            reportTable.put(reporter, set);
        }
    }
    
    private void setReportCounter() {
        for (String id : reportTable.keySet()) {
            HashSet<String> set = reportTable.get(id);
            for (String reportedPerson : set) {
                // System.out.println("report : " + reportedPerson);
                Integer counter = reportCounter.getOrDefault(reportedPerson, 0);
                reportCounter.put(reportedPerson, counter + 1);
            }
        }
    }
    
    private void printReportTable() {
        for (String id : reportTable.keySet()) {
            System.out.print("id = " + id + " ::");
            HashSet<String> set = reportTable.get(id);
            for (String reportedPerson : set) {
                System.out.print(" " + reportedPerson);
            }
            System.out.println();
        }
        
    }
    
    private void setAnswer(int[] answer, String[] id_list, int k) {
        for (String reporter : reportTable.keySet()) {
            HashSet<String> reportedPeople = reportTable.get(reporter);
            for (String reportedPerson : reportedPeople) {
                if (reportCounter.getOrDefault(reportedPerson, 0) >= k) {
                    answer[changeIdListToIndex(id_list, reporter)]++;
                }
            }
        }
    }
    
    private int changeIdListToIndex(String[] id_list, String id) {
        for (int i = 0; i < id_list.length; i++) {
            if (id.equals(id_list[i])) {
                return i;
            }
        }
        return 0;
    }
}