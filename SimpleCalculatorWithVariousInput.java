
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleCalculatorWithVariousInput {

    public static void main(String[] args) {
        LogicHandeling LG = new LogicHandeling();
        System.out.println("------------------Calculator Menu------------------");
        LG.loopLogic();
    }

}

class LogicHandeling {

    Calculotorfunction Cf = new Calculotorfunction();
    Scanner sc = new Scanner(System.in);
    List<Double> userEnteredList = new ArrayList<>();

    void loopLogic() {

        try {

            for (;;) {

                System.out.println("Enter the no for which operation you want to perform ");
                System.out.println("         1 if you want to add two no ");
                System.out.println("         2 if you want to sub two no ");
                System.out.println("         3 if you want to mul two no ");
                System.out.println("         4 if you want to view the History  ");
                System.out.println("         5 if you want to generate a .txt file of history");
                System.out.println("         6 if you want to terminate the program");
                System.out.print("         Enter the no :- ");
                int selectCase = sc.nextInt();
                System.out.println("");

                if (selectCase == 6) {
                    System.out.println("       You terminated the session.");
                    System.out.println("");
                    break;
                }
                if (selectCase == 4) {
                    Cf.history();
                    continue;
                }
                if (selectCase == 5) {
                    Cf.generatHistoryTxt();
                    continue;
                }

                if (selectCase >= 1 && selectCase <= 3) {

                    System.out.println("Enter the no of values you are going to use in your Operation");
                    int NumberOfValues = sc.nextInt();
                    for (int i = 0; i < NumberOfValues; i++) {
                        System.out.println("enter element at:- "+i);
                        userEnteredList.add(sc.nextDouble());
                    }
                    System.out.println("");


                    switch (selectCase) {
                        case 1:
                            Cf.add(userEnteredList);
                            break;
                        case 2:
                            Cf.sub(userEnteredList);
                            break;
                        case 3:
                            Cf.mult(userEnteredList);
                            break;
                        

                        default:
                            System.out.println("Illigle value choes between 1 to 5 ");
                    }
                } else if (selectCase < 1 || selectCase > 6) {
                    System.out.println("      Illigle value ReEnter the value ");
                    System.out.println("");
                }

            }
        } catch (Exception e) {
            System.out.println("");
            System.out.println("You entered something which was illegle so the whole session was terminated ");
            System.out.println("");
        }
        sc.close();

    }
}

class Calculotorfunction {

    List<String> History = new ArrayList<>();

    void add(List<Double> userEnteredList) {
        double Addition = 0;
        for(double ele: userEnteredList){
            Addition+=ele;
        }
        System.out.println("Addition of every element is = "+Addition);
        History.add("Addition of " + userEnteredList + " is " + Addition);
        System.out.println("");

    }

    void sub(List<Double> userEnteredList) {
        double Substraction = 0;
        for(double ele: userEnteredList){
            Substraction-=ele;
        }
        System.out.println("Substraction of Two no is = " + Substraction);
        History.add("Substraction of " + userEnteredList + " is " + Substraction);
        System.out.println("");
    }


    void mult(List<Double> userEnteredList) {
       
        double Multiplication = 1;
        for(double ele: userEnteredList){
            Multiplication*=ele;
        }
        System.out.println("Multiplication of Two no is = " + Multiplication);
        History.add("Multiplication of " + userEnteredList + " is " + Multiplication);
        System.out.println("");
    }

    void history() {
        System.out.println("---------History of your records--------- ");
        int count = 1;
        for (String elem : History) {
            System.out.println(count++ + " " + elem);
        }
    }

    void generatHistoryTxt() throws IOException {
        FileWriter HistoryToTxt = new FileWriter("historyOfCalculatorMultiValue.txt");
        int size = History.size();
        for (int i = 0; i < size; i++) {
            String str = History.get(i);
            HistoryToTxt.write(str);
            if (i < size - 1) {
                HistoryToTxt.write("\n");
            }
        }
        System.out.println("The file has been generated with the name historyOfCalculator.txt ");
        HistoryToTxt.close();
    }
}
