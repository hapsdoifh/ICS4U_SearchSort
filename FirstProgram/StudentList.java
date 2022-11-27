import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    ArrayList <Students> mylist = new ArrayList<Students>();

    public StudentList(String[] st, int sn){
        for(String i : st){
            mylist.add(new Students(i,sn));
        }
    }

    public StudentList(){
    }

    public ArrayList <Students> getList(){
        return mylist;
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
            System.out.println("The name you searched already existes" + "\nThis is their student number: \t" + tempStudent.getSN());
        }else{
            System.out.print("The name you searched does not exist, would you like to add it (yes/no): \t");
            if(sc.nextLine().equals("yes")){
                System.out.print("Add their student number, enter -1 if N/A : \t");
                mylist.add(new Students(name,sc.nextInt()));
            }
        }
    }

    public void outputStudentList(ArrayList<Students> l){
        for(Students S : l){
            System.out.println(S.getName() +":" + S.getSN());    
        }
    }

    public ArrayList <Students> Merge(ArrayList <Students> A, ArrayList <Students> B,boolean order){
        ArrayList <Students> rList = new ArrayList <Students>();
        int ac = 0, bc = 0, rcnt = 0, charPos = 0;
        while(ac < A.size() && bc < B.size()){
            while(charPos < A.get(ac).getName().length() && charPos < B.get(bc).getName().length()){ //loop through the word if necessary
                if(A.get(ac).getName().charAt(charPos) == B.get(bc).getName().charAt(charPos)){
                    charPos++;
                }else if((A.get(ac).getName().charAt(charPos) < B.get(bc).getName().charAt(charPos))==order){
                    rList.add(new Students(A.get(ac).getName(),A.get(ac).getSN()));
                    ac++;
                    break;
                }
                else{
                    rList.add(new Students(B.get(bc).getName(),B.get(bc).getSN()));
                    bc++;
                    break;
                }
            }
            rcnt++;
        }
        //if A not empty
        while(ac < A.size()){
            rList.add(new Students(A.get(ac).getName(),A.get(ac).getSN()));
            ac++;
            rcnt++;
        }
        while(bc < B.size()){
            rList.add(new Students(B.get(bc).getName(),B.get(bc).getSN()));
            bc++;
            rcnt++;
        }
        return rList;
    }

    public ArrayList <Students> sortByAlpha(boolean order, int start, int end){
        ArrayList <Students> tempListA = new ArrayList <Students>();
        ArrayList <Students> tempListB = new ArrayList <Students>();
        if(end-start <= 1){
            if(end-start <= 0){              
                tempListA.add(mylist.get(start));
                return tempListA;
            }
            tempListA.add(mylist.get(start));
            tempListB.add(mylist.get(end));
            return Merge(tempListA,tempListB, order);            
        }else{
            tempListA = sortByAlpha(order, start, (end+start)/2);
            tempListB = sortByAlpha(order, (end+start)/2+1, end);
            return Merge(tempListA,tempListB, order);            
        }

    }
}
