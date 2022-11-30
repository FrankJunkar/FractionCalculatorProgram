import java.util.Scanner;
import java.lang.Math;
public class FracCalc {

    public static void main(String[] args) {
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

    public static String parseFirstFrac(String input) {
        String[] arr = input.split(" ");
        String firstOper = arr[0];
        String operator = arr[1];
        String secondOper = arr[2];

        if (firstOper.indexOf("_") != -1) {
            String[] firstOperArr = firstOper.split("_");
            int firstOperWhole = Integer.parseInt(firstOperArr[0]);
            String firstOperFraction = firstOperArr[1];

            String[] firstOperFractionArr = firstOperFraction.split("/");
            int firstOperNumer = Integer.parseInt(firstOperFractionArr[0]);
            int firstOperDenom = Integer.parseInt(firstOperFractionArr[1]);
            if (firstOperWhole < 0) {
                firstOperNumer = -1 * firstOperNumer;
            }
            return operator + " " + firstOperWhole + " " + firstOperNumer + " " + firstOperDenom;
        }
        else {
            if (firstOper.indexOf("/") != -1) {
                int firstOperWhole = 0;

                String[] firstOperFractionArr = firstOper.split("/");
                int firstOperNumer = Integer.parseInt(firstOperFractionArr[0]);
                int firstOperDenom = Integer.parseInt(firstOperFractionArr[1]);
                return operator + " " + firstOperWhole + " " + firstOperNumer + " " + firstOperDenom;
            }
            else {
                int firstOperWhole = Integer.parseInt(firstOper);
                int firstOperNumer = 0;
                int firstOperDenom = 1;
                return operator + " " + firstOperWhole + " " + firstOperNumer + " " + firstOperDenom;
            }
        }
    }

    public static String parseSecondFrac(String input) {
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
            if (secondOperWhole < 0) {
                secondOperNumer = -1 * secondOperNumer;
            }
            return operator + " " + secondOperWhole + " " + secondOperNumer + " " + secondOperDenom;
        }
        else {
            if (secondOper.indexOf("/") != -1) {
                int secondOperWhole = 0;

                String[] secondOperFractionArr = secondOper.split("/");
                int secondOperNumer = Integer.parseInt(secondOperFractionArr[0]);
                int secondOperDenom = Integer.parseInt(secondOperFractionArr[1]);
                return operator + " " + secondOperWhole + " " + secondOperNumer + " " + secondOperDenom;
            }
            else {
                int secondOperWhole = Integer.parseInt(secondOper);
                int secondOperNumer = 0;
                int secondOperDenom = 1;
                return operator + " " + secondOperWhole + " " + secondOperNumer + " " + secondOperDenom;
            }
        }
    }

    public static String add(String input) {
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * den2 + num2 * den1;
        int den = den1 * den2;

        return simplify(num, den);
    }

    public static String subtract(String input) {
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * den2 - num2 * den1;
        int den = den1 * den2;

        return simplify(num, den);
    }

    public static String multiply(String input) {
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * num2;
        int den = den1 * den2;

        return simplify(num, den);
    }

    public static String divide(String input) {
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * den2;
        int den = num2 * den1;

        return simplify(num, den);
    }

    public static String simplify(int num, int denom) {
        int numerator = num;
        int denominator = denom;

        if ((numerator > 0 && denominator < 0) || numerator < 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        for (int i = Math.abs(denominator); i > 1; i --) {
            while ((numerator % i == 0) && (denominator % i == 0)) {
                numerator /= i;
                denominator /= i;
            }
        }
        if (denominator == 1) {
            return "" + numerator;
        }
        else if (numerator == 0) {
            return "0";
        }
        else {
            if (Math.abs(numerator) > Math.abs(denominator)) {
                if ((Math.abs(numerator) % Math.abs(denominator)) == 0) {
                    return "" + numerator / denominator;
                }
                else {
                    return (numerator / denominator) + "_" + (Math.abs(numerator) % Math.abs(denominator)) + "/" + Math.abs(denominator);
                }
            }
            else {
                return numerator + "/" + denominator;
            }
        }
    }

    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input

        String[] arr = input.split(" ");
        String firstOper = arr[0];
        String operator = arr[1];

        if (operator.equals("+")) {
            return add(input);
        }

        else if (operator.equals("-")) {
            return subtract(input);
        }

        else if (operator.equals("*")) {
            return multiply(input);
        }

        else {
            return divide(input);
        }
    }
}
