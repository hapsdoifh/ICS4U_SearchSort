package SecondProgram;
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Temperature {
    class temps{
        public double temp;
        public double day;
        public temps(double t, double d){
            temp = t;
            day = d;
        }
    }
    private ArrayList<temps> tempList = new ArrayList<temps>();
    
    public void inputTemp(){
        Scanner sc = new Scanner(System.in);
        double t,d;
        System.out.println("Temperature: ");
        t = sc.nextDouble();
        System.out.println("Day number: ");
        d = sc.nextDouble();
        tempList.add(new temps(t, d));
    }

    public ArrayList<temps> SelectionSort(boolean order){
        ArrayList<temps> SortedList = new ArrayList<temps>();
        temps TransferStore;
        int minInd = 0;
        double min = tempList.get(minInd).temp;
        for(int i=0; i<tempList.size(); i++){           
            for(int k = i; k < tempList.size(); k++){
                if(tempList.get(k).temp < min){
                    min = tempList.get(k).temp;
                    minInd = k;
                }
            }
            TransferStore = tempList.get(minInd);
            tempList.set(i,tempList.get(minInd));
            tempList.set(minInd,TransferStore); 
        }

        return SortedList;
    }
     
    public double[][] convertList(ArrayList<temps> givenList){
        double[][] rList = new double [2][givenList.size()];
        for(int i = 0; i<givenList.size(); i++){
            rList[0][i] = givenList.get(i).temp;
            rList[1][i] = givenList.get(i).day;
        }
        return rList;
    }
}
