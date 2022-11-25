import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    ArrayList <Students> mylist = new ArrayList<Students>();;
    Students[] sortedStudent;

    public StudentList(String[] st){
        for(String i : st){
            mylist.add(new Students(i));
        }
    }
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
            System.out.print("The name you searched does not exist, would you like to add it (yes/no): ");
            if(sc.nextLine().equals("yes")){
                mylist.add(new Students(name));
            }
            System.out.print("Would you like to add their student number (yes/no): ");
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

    public Students[] Merge(Students[] A, Students[] B){
        Students[] rList = new Students[A.length+B.length];
        int ac = 0, bc = 0, rcnt = 0;
        while(ac < A.length && bc < B.length){
            if(A[ac].getName().charAt(0) < B[bc].getName().charAt(0)){
                rList[rcnt] = new Students(A[ac].getName());
                ac++;
            }else{
                rList[rcnt] = new Students(B[bc].getName());
                bc++;
            }
            rcnt++;
        }
        //if A not empty
        while(ac < A.length){
            rList[rcnt] = new Students(A[ac].getName());
            ac++;
            rcnt++;
        }
        while(bc < B.length){
            rList[rcnt] = new Students(B[bc].getName());
            bc++;
            rcnt++;
        }
        return rList;
    }

    public Students[] sortByAlpha(boolean order, Students[] listToSort,int start, int end){
        if(end-start <= 1){
            Students[] tempListA = new Students[1];
            Students[] tempListB = new Students[1];
            if(end-start <= 0){                
                tempListA = new Students[1];
                tempListA[0] = listToSort[start];
                return tempListA;
            }
            tempListA[0] = listToSort[start];
            tempListB[0] = listToSort[end];
            return Merge(tempListA,tempListB);            
        }else{
            Students[] tempListA = sortByAlpha(order, listToSort, start, (end+start)/2);
            Students[] tempListB = sortByAlpha(order, listToSort, (end+start)/2+1, end);
            return Merge(tempListA,tempListB);            
        }

    }
}
