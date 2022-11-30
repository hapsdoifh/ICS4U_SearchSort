package SecondProgram;

import SecondProgram.Temperature.temps;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        //DO ADD/CHANGE how the list is inputted
        
        Scanner keyboard = new Scanner(System.in);
        Temperature myTemp = new Temperature();
        String inpt = "";

        //take user input
        while(myTemp.inputTemp());
        System.out.print("Enter the order you wish to sort (true:small-big | false:big-small): ");
        inpt = keyboard.nextLine();
        boolean searchOrd = Boolean.parseBoolean(inpt);
        double [][] sortedList = myTemp.convertList(myTemp.SelectionSort(searchOrd));
        
        //output sorted List
        
        for(int i = 0; i< sortedList[0].length; i++){   
            System.out.print("Temperature:\t "+sortedList[0][i]);
            System.out.println("\\ttDay:\t "+ (int)sortedList[1][i]);
        }
        System.out.println();
        while(true){
            System.out.print("Enter a temperature you want to search (Enter \"q\" to quit): ");
            inpt = keyboard.nextLine();
            if(inpt.equals("q")){
                break;
            }else if(inpt.equals("")){
                System.out.println("Invalid, please try again");
                continue;
            }else{
                double searchTarget = Double.parseDouble(inpt);
                System.out.println("It is found at index: "+(myTemp.BinarySearch(myTemp.SelectionSort(searchOrd),searchTarget,searchOrd)+1));  
            }
        }
    }
}