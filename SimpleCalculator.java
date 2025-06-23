
import java.util.Scanner;

class SimpleCalculator {

    public static void main(String[] args) {
        Calculotorfunction Cf = new Calculotorfunction();
        Scanner sc = new Scanner(System.in);
        try {

            for (;;) {
                System.out.println("------------------Calculator Menu------------------");
                System.out.println("Enter the no for which operation you want to perform ");
                System.out.println("         1 if you want to add two no ");
                System.out.println("         2 if you want to sub two no ");
                System.out.println("         3 if you want to dev two no ");
                System.out.println("         4 if you want to mul two no ");
                System.out.print("         5 if you want to terminate:- ");
                int selectCase = sc.nextInt();
                System.out.println("");
                if (selectCase == 5) {
                    System.out.println("You terminated the session.");
                    break;
                }
                if (selectCase > 5 || selectCase < 1) {
                    System.out.println("Illigle value ReEnter the value ");
                    continue;
                }
                System.out.print("Enter the first no  :- ");
                double userInpur1 = sc.nextDouble();
                System.out.print("Enter the second no :- ");
                double userInpur2 = sc.nextDouble();

                System.out.println("");

                switch (selectCase) {
                    case 1 ->
                        Cf.add(userInpur1, userInpur2);
                    case 2 ->
                        Cf.sub(userInpur1, userInpur2);
                    case 3 ->
                        Cf.dev(userInpur1, userInpur2);
                    case 4 ->
                        Cf.mult(userInpur1, userInpur2);
                    default ->
                        System.out.println("Illigle value choes between 1 to 5 ");
                }

            }
        } catch (Exception e) {
            System.out.println("");
            System.out.println("You entered something which was illegle so the whole session was terminated ");
            System.out.println("");
        }
        sc.close();

    }

    public void ExecuteLogic() {

    }

}

class Calculotorfunction {

    void add(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;
        double Addition = a + b;
        System.out.println("Addition of Two no is = " + Addition);
        System.out.println("");

    }

    void sub(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;
        double Substraction = a - b;
        System.out.println("Substraction of Two no is = " + Substraction);
        System.out.println("");
    }

    void dev(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;

        if (userInpur2 != 0) {
            double Devision = a / b;
            System.out.println("Devision of Two no is = " + Devision);
            System.out.println("");
        } else {
            System.out.println("Divide by 0 gives an Arathmatis Exception ");
            System.out.println("");
        }

    }

    void mult(double userInpur1, double userInpur2) {
        double a = userInpur1;
        double b = userInpur2;
        double Multiplication = a * b;
        System.out.println("Multiplication of Two no is = " + Multiplication);
        System.out.println("");
    }
}
