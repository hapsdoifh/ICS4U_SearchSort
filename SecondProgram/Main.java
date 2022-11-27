package SecondProgram;

import SecondProgram.Temperature.temps;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        //DO ADD/CHANGE how the list is inputted
        Scanner keyboard = new Scanner(System.in);
        double[] j = {19,20.4,49.1,16.3,13.6};
        Temperature myTemp = new Temperature(j);
        String inpt = "";
        //while(myTemp.inputTemp());
        double [][] k = myTemp.convertList(myTemp.SelectionSort(false));
        for(double[] outpt : k){         
            for(double dbOut : outpt){
                System.out.print(dbOut + "\t");
            }   
            System.out.println();
        }
        System.out.print(myTemp.BinarySearch(myTemp.SelectionSort(false),16.3)+1);

    }
}