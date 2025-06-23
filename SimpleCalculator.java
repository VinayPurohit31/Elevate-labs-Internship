
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SimpleCalculator {

    public static void main(String[] args) {
        LogicHandeling LG = new LogicHandeling();
        System.out.println("------------------Calculator Menu------------------");
        LG.loopLogic();
    }

}

class LogicHandeling {

    Calculotorfunction Cf = new Calculotorfunction();
    Scanner sc = new Scanner(System.in);

    void loopLogic() {

        try {

            for (;;) {

                System.out.println("Enter the no for which operation you want to perform ");
                System.out.println("         1 if you want to add two no ");
                System.out.println("         2 if you want to sub two no ");
                System.out.println("         3 if you want to dev two no ");
                System.out.println("         4 if you want to mul two no ");
                System.out.println("         5 if you want to view the History  ");
                System.out.println("         6 if you want to generate a .txt file of history");
                System.out.println("         7 if you want to terminate the program");
                System.out.print("         Enter the no :- ");
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
                    Cf.generatHistoryTxt();
                    continue;
                }
                if (selectCase >= 1 && selectCase <= 4) {
                    System.out.print("Enter the first no  :- ");
                    double userInpur1 = sc.nextDouble();
                    System.out.print("Enter the second no :- ");
                    double userInpur2 = sc.nextDouble();
                    System.out.println("");

                    System.out.println("");

                    switch (selectCase) {
                        case 1:
                            Cf.add(userInpur1, userInpur2);
                            break;
                        case 2:
                            Cf.sub(userInpur1, userInpur2);
                            break;
                        case 3:
                            Cf.dev(userInpur1, userInpur2);
                            break;
                        case 4:
                            Cf.mult(userInpur1, userInpur2);
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

    void add(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;
        double Addition = a + b;
        System.out.println("Addition of Two no is = " + Addition);
        History.add("Addition of " + a + " and " + b + " is " + Addition);
        System.out.println("");

    }

    void sub(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;
        double Substraction = a - b;
        System.out.println("Substraction of Two no is = " + Substraction);
        History.add("Substraction of " + a + " and " + b + " is " + Substraction);
        System.out.println("");
    }

    void dev(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;

        if (userInpur2 != 0) {
            double Devision = a / b;
            System.out.println("Devision of Two no is = " + Devision);
            History.add("Devision of " + a + " and " + b + " is " + Devision);
            System.out.println("");
        } else {
            System.out.println("Divide by 0 gives an Arathmatis Exception ");
            History.add("Devision of " + a + " and " + b + " failed: Division by zero.");
            System.out.println("");
        }

    }

    void mult(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;
        double Multiplication = a * b;
        System.out.println("Multiplication of Two no is = " + Multiplication);
        History.add("Multiplication of " + a + " and " + b + " is " + Multiplication);
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
        FileWriter HistoryToTxt = new FileWriter("historyOfCalculator.txt");
        int size=History.size();
        for(int i=0;i<size;i++){
            String str=History.get(i);
            HistoryToTxt.write(str);
            if(i< size-1){
                HistoryToTxt.write("\n");
            }
        }
        System.out.println("The file has been generated with the name historyOfCalculator.txt ");
        HistoryToTxt.close();
    }
}
