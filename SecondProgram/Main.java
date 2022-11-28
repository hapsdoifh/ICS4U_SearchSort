package SecondProgram;

import SecondProgram.Temperature.temps;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        //DO ADD/CHANGE how the list is inputted
        
        Scanner keyboard = new Scanner(System.in);
        Temperature myTemp = new Temperature();
        String inpt = "";
        while(myTemp.inputTemp());
        System.out.print("Enter the order you wish to sort (true - small to big | false - big to small): ");
        boolean searchOrd = keyboard.nextBoolean();
        double [][] sortedList = myTemp.convertList(myTemp.SelectionSort(searchOrd));
        
        String[] Label = {"Temperature:\t ", "Day:\t\t "};
        for(int i = 0; i< 2; i++){   
            System.out.print(Label[i]);      
            for(double dbOut : sortedList[i]){
                System.out.print(dbOut + "\t");
            }   
            System.out.println();
        }
        System.out.print("Enter a temperature you want to search: ");
        double searchTarget = keyboard.nextDouble();
        System.out.print("It is found at index: "+(myTemp.BinarySearch(myTemp.SelectionSort(searchOrd),searchTarget)+1));

    }
}