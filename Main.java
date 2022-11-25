import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StudentList testList = new StudentList();
        System.out.print("Start? (yes/no): ");  
        while(s.nextLine().equals("yes") == true){
            System.out.print("Enter a name you want to search: ");
            testList.process_Search(s.nextLine());
            System.out.print("continue? (yes/no): ");                    
        }
        testList.outputStudentList();
    }
}
