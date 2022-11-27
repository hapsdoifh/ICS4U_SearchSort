package SecondProgram;
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.transform.Templates;

public class Temperature {
    class temps{
        public double temp;
        public int  day;
        public temps(double t, int d){
            temp = t;
            day = d;
        }
    }
    private ArrayList<temps> tempList = new ArrayList<temps>();
    public Temperature(double[] tps){
        for(int i = 0; i<tps.length; i++){
            tempList.add(new temps(tps[i],i));
        }
    }
    public boolean inputTemp(){
        Scanner sc = new Scanner(System.in);
        String t,d;
        System.out.println();
        System.out.print("Temperature (q to quit): ");
        t = sc.nextLine();
        if(t.equals("q")){
            return false;
        }
        System.out.print("Day number (q to quit): ");
        d = sc.nextLine();
        if(d.equals("q")){
            return false;
        }
        tempList.add(new temps(Double.parseDouble(t), Integer.parseInt(d)));
        return true;
    }

    public ArrayList<temps> SelectionSort(boolean order){
        ArrayList<temps> SortedList = new ArrayList<temps>();
        for(temps cp : tempList){
            SortedList.add(new temps(cp.temp, cp.day));
        }
        temps TransferStore;
        int minInd = 0;
        double min = SortedList.get(minInd).temp;
        for(int i=0; i<SortedList.size(); i++){     
            min = SortedList.get(i).temp;
            minInd = i;      
            for(int k = i; k < SortedList.size(); k++){
                if(SortedList.get(k).temp < min){
                    min = SortedList.get(k).temp;
                    minInd = k;
                }
            }
            TransferStore = SortedList.get(i);
            SortedList.set(i,SortedList.get(minInd));
            SortedList.set(minInd,TransferStore); 
        }
        return SortedList;
    }
    
    public int BinarySearch(ArrayList<temps> SortedList, double target){
        int SearchInd;
        int start=0, end=SortedList.size()-1;
        while(start != end){
            SearchInd=start+end/2;
            if(SortedList.get(SearchInd).temp == target){
                return SearchInd;
            }else if(SortedList.get(SearchInd).temp > target){
                end = SearchInd;
            }else{
                start = SearchInd;
            }     
        }
        return -1;
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
