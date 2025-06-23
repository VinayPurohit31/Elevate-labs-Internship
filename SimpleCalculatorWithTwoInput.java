import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SimpleCalculatorWithTwoInput {

    public static void main(String[] args) {
        LogicHandling LG = new LogicHandling();
        System.out.println("------------------Calculator Menu------------------");
        LG.loopLogic();
    }
}

class LogicHandling {

    CalculatorFunction Cf = new CalculatorFunction();
    Scanner sc = new Scanner(System.in);

    void loopLogic() {

        try {

            for (;;) {

                System.out.println("Enter the number for the operation you want to perform ");
                System.out.println("         1 if you want to add two numbers ");
                System.out.println("         2 if you want to subtract two numbers ");
                System.out.println("         3 if you want to divide two numbers ");
                System.out.println("         4 if you want to multiply two numbers ");
                System.out.println("         5 if you want to view the history  ");
                System.out.println("         6 if you want to generate a .txt file of history");
                System.out.println("         7 if you want to terminate the program");
                System.out.print("         Enter the number :- ");
                int selectCase = sc.nextInt();
                System.out.println("");
                if (selectCase == 7) {
                    System.out.println("       You terminated the session.");
                    System.out.println("");
                    break;
                }
                if (selectCase == 5) {
                    Cf.history();
                    continue;
                }
                if (selectCase == 6) {
                    Cf.generateHistoryTxt();
                    continue;
                }
                if (selectCase >= 1 && selectCase <= 4) {
                    System.out.print("Enter the first number  :- ");
                    double userInput1 = sc.nextDouble();
                    System.out.print("Enter the second number :- ");
                    double userInput2 = sc.nextDouble();
                    System.out.println("");
                    System.out.println("");

                    switch (selectCase) {
                        case 1 -> Cf.add(userInput1, userInput2);
                        case 2 -> Cf.sub(userInput1, userInput2);
                        case 3 -> Cf.div(userInput1, userInput2);
                        case 4 -> Cf.mult(userInput1, userInput2);
                        default -> System.out.println("Illegal value chosen between 1 to 5 ");
                    }
                } else if (selectCase < 1 || selectCase > 6) {
                    System.out.println("      Illegal value. Re-enter the value ");
                    System.out.println("");
                }

            }
        } catch (Exception e) {
            System.out.println("");
            System.out.println("You entered something illegal, so the whole session was terminated ");
            System.out.println("");
        }
        sc.close();
    }
}

class CalculatorFunction {

    List<String> History = new ArrayList<>();

    void add(double userInput1, double userInput2) {
      
        double Addition = userInput1 + userInput2;
        System.out.println("Addition of two numbers is = " + Addition);
        History.add("Addition of " + userInput1 + " and " + userInput2 + " is " + Addition);
        System.out.println("");
    }

    void sub(double userInput1, double userInput2) {
       
        double Subtraction = userInput1 - userInput2;
        System.out.println("Subtraction of two numbers is = " + Subtraction);
        History.add("Subtraction of " + userInput1 + " and " + userInput2 + " is " + Subtraction);
        System.out.println("");
    }

    void div(double userInput1, double userInput2) {
        

        if (userInput2 != 0) {
            double Division = userInput1 / userInput2;
            System.out.println("Division of two numbers is = " + Division);
            History.add("Division of " + userInput1 + " and " + userInput2 + " is " + Division);
            System.out.println("");
        } else {
            System.out.println("Divide by 0 causes an Arithmetic Exception ");
            History.add("Division of " + userInput1 + " and " + userInput2 + " failed: Division by zero.");
            System.out.println("");
        }
    }

    void mult(double userInput1, double userInput2) {
       
        double Multiplication = userInput1 * userInput2;
        System.out.println("Multiplication of two numbers is = " + Multiplication);
        History.add("Multiplication of " + userInput1 + " and " + userInput2 + " is " + Multiplication);
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
        try (FileWriter HistoryToTxt = new FileWriter("historyOfCalculator.txt")) {
            int size = History.size();
            for (int i = 0; i < size; i++) {
                String str = History.get(i);
                HistoryToTxt.write(str);
                if (i < size - 1) {
                    HistoryToTxt.write("\n");
                }
            }
            System.out.println("The file has been generated with the name historyOfCalculator.txt ");
        }
    }
}
