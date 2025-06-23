import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleCalculatorWithVariousInput {

    public static void main(String[] args) {
        LogicHandling LG = new LogicHandling();
        System.out.println("------------------Calculator Menu------------------");
        LG.loopLogic();
    }

}

class LogicHandling {

    CalculatorFunction Cf = new CalculatorFunction();
    Scanner sc = new Scanner(System.in);
    List<Double> userEnteredList = new ArrayList<>();

    void loopLogic() {

        try {
            for (;;) {

                System.out.println("Enter the number for which operation you want to perform ");
                System.out.println("         1 if you want to add two numbers ");
                System.out.println("         2 if you want to subtract two numbers ");
                System.out.println("         3 if you want to multiply two numbers ");
                System.out.println("         4 if you want to view the History  ");
                System.out.println("         5 if you want to generate a .txt file of history");
                System.out.println("         6 if you want to terminate the program");
                System.out.print("         Enter the number :- ");
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
                    Cf.generateHistoryTxt();
                    continue;
                }

                if (selectCase >= 1 && selectCase <= 3) {

                    System.out.println("Enter the number of values you are going to use in your Operation");
                    int numberOfValues = sc.nextInt();
                    for (int i = 0; i < numberOfValues; i++) {
                        System.out.println("enter element at:- " + i);
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
                            System.out.println("Illegal value choose between 1 to 5 ");
                    }

                    // Clear the list after each operation
                    userEnteredList.clear();

                } else if (selectCase < 1 || selectCase > 6) {
                    System.out.println("      Illegal value. Re-enter the value ");
                    System.out.println("");
                }

            }
        } catch (Exception e) {
            System.out.println("");
            System.out.println("You entered something which was illegal so the whole session was terminated ");
            System.out.println("");
        }
        sc.close();
    }
}

class CalculatorFunction {

    List<String> History = new ArrayList<>();

    void add(List<Double> userEnteredList) {
        double addition = 0;
        for (double ele : userEnteredList) {
            addition += ele;
        }
        System.out.println("Addition of every element is = " + addition);
        History.add("Addition of " + userEnteredList + " is " + addition);
        System.out.println("");
    }

    void sub(List<Double> userEnteredList) {
        if (userEnteredList.size() == 0) {
            System.out.println("Subtraction operation requires at least one value.");
            return;
        }

        double subtraction = userEnteredList.get(0);
        for (int i = 1; i < userEnteredList.size(); i++) {
            subtraction -= userEnteredList.get(i);
        }
        System.out.println("Subtraction of values is = " + subtraction);
        History.add("Subtraction of " + userEnteredList + " is " + subtraction);
        System.out.println("");
    }

    void mult(List<Double> userEnteredList) {
        double multiplication = 1;
        for (double ele : userEnteredList) {
            multiplication *= ele;
        }
        System.out.println("Multiplication of values is = " + multiplication);
        History.add("Multiplication of " + userEnteredList + " is " + multiplication);
        System.out.println("");
    }

    void history() {
        System.out.println("---------History of your records--------- ");
        int count = 1;
        for (String elem : History) {
            System.out.println(count++ + " " + elem);
        }
    }

    void generateHistoryTxt() throws IOException {
        FileWriter HistoryToTxt = new FileWriter("historyOfCalculatorMultiValue.txt");
        int size = History.size();
        for (int i = 0; i < size; i++) {
            String str = History.get(i);
            HistoryToTxt.write(str);
            if (i < size - 1) {
                HistoryToTxt.write("\n");
            }
        }
        System.out.println("The file has been generated with the name historyOfCalculatorMultiValue.txt");
        HistoryToTxt.close();
    }
}
