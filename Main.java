import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        String [] tp = {"Bob","Cathy","Harry","Dan","Frank","Underwood"};
        Students [] jp = new Students[6];

        for(int i = 0; i<6; i++){
            jp[i] = new Students(tp[i]);
        }
        StudentList testList = new StudentList(tp);
        Students[] k = testList.sortByAlpha(true, jp, 0, jp.length-1);
        System.out.println("test");
        // System.out.print("Start? (yes/no): ");  
        // while(s.nextLine().equals("yes") == true){
        //     System.out.print("Enter a name you want to search: ");
        //     testList.process_Search(s.nextLine());
        //     System.out.print("continue? (yes/no): ");                    
        // }
        // testList.outputStudentList();\
    }
}
