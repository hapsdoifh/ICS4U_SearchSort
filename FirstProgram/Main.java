import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String buffer;
        
        StudentList testList = new StudentList();
        while(true){
            System.out.println();                    
            System.out.print("Enter a name you want to search (enter \"exit\" to quit): \t");
            buffer=s.nextLine();
            if(buffer.equals("exit")){
                break;
            }else{
                testList.process_Search(buffer);
            }
        }
        System.out.println("List before Sorting:");
        testList.outputStudentList(testList.getList());        
        
        System.out.println();
        System.out.print("Enter order of sort (true:A-Z | false:Z-A):");
        boolean ord = s.nextBoolean();
        System.out.println("List after Sorting:");
        testList.outputStudentList(testList.AlphaMergeSort(ord, 0, testList.getList().size()-1));      
    }
}
