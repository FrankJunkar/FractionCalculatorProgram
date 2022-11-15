import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner reader = new Scanner(System.in);
        boolean inputting = true;
        while (inputting) {
            String input = reader.nextLine();
            if (input.equals("quit")) {
                break;
            }
            System.out.println(produceAnswer(input));
        }
    }

    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
        String[] arr = input.split(" ");
        String firstOper = arr[0];
        String operator = arr[1];
        String secondOper = arr[2];

        if (secondOper.indexOf("_") != -1) {
            String[] secondOperArr = secondOper.split("_");
            int secondOperWhole = Integer.parseInt(secondOperArr[0]);
            String secondOperFraction = secondOperArr[1];

            String[] secondOperFractionArr = secondOperFraction.split("/");
            int secondOperNumer = Integer.parseInt(secondOperFractionArr[0]);
            int secondOperDenom = Integer.parseInt(secondOperFractionArr[1]);
            return ("whole:" + secondOperWhole + " numerator:" + secondOperNumer + " denominator:" + secondOperDenom);
        }

        else {
            if (secondOper.indexOf("/") != -1) {
                int secondOperWhole = 0;

                String[] secondOperFractionArr = secondOper.split("/");
                int secondOperNumer = Integer.parseInt(secondOperFractionArr[0]);
                int secondOperDenom = Integer.parseInt(secondOperFractionArr[1]);
                return ("whole:" + secondOperWhole + " numerator:" + secondOperNumer + " denominator:" + secondOperDenom);
            }

            else {
                int secondOperWhole = Integer.parseInt(secondOper);
                int secondOperNumer = 0;
                int secondOperDenom = 1;
                return ("whole:" + secondOperWhole + " numerator:" + secondOperNumer + " denominator:" + secondOperDenom);
            }

        }
    }
}
