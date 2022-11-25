import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    ArrayList <Students> mylist = new ArrayList<Students>();;
    Students[] sortedStudent;

    public Students findStudent(String target){
        for(int i = 0; i<mylist.size(); i++){
            if(mylist.get(i).getName().equals(target)){
                return mylist.get(i);
            }
        }
        return null;
    }

    
    public void process_Search(String name){
        Scanner sc = new Scanner(System.in);
        Students tempStudent = findStudent(name);
        if(tempStudent!=null){
            System.out.println("The name you searched already existes" + "\nThis is their student number: " + tempStudent.getSN());
        }else{
            System.out.print("The name you searched does not exist, would you like to add it (yes/no)");
            if(sc.nextLine().equals("yes")){
                mylist.add(new Students(name));
            }
            System.out.print("Would you like to add their student number (yes/no)");
            if(sc.nextLine().equals("yes")){
                System.out.print("Student Number: ");
                mylist.get(mylist.size()-1).setSN(sc.nextInt());
            }
        }
    }

    public void outputStudentList(){
        for(Students S : mylist){
            System.out.println(S.getName());
        }
    }

}
