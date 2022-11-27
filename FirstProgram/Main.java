import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Start? (yes/no): \t\t");  
        StudentList testList = new StudentList();
        while(s.nextLine().equals("yes") == true){
            System.out.println();                    
            System.out.print("Enter a name you want to search: \t");
            testList.process_Search(s.nextLine());
            System.out.print("continue? (yes/no): \t\t");
        }
        testList.outputStudentList(testList.getList());        
        testList.sortByAlpha(true, 0, testList.getList().size()-1);
        System.out.println();
        testList.outputStudentList(testList.sortByAlpha(true, 0, testList.getList().size()-1));      
    }
}
