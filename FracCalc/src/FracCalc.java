import java.util.Scanner;
import java.lang.Math;

/**
 * A class that has main, parseFirstFrac,
 * parseSecondFrac, add, subtract,
 * multiply, divide, simplify,
 * and produceAnswer methods
 * @author fjunkar
 * @since 2022-12-02
 */
public class FracCalc {
    /**
     * No instance variables
     * constructors
     * @author fjunkar
     * since 2022-12-02
     */

    /**
     * main method that creates a scanner,
     * checks for if user is inputting,
     * and prints the simplified fractio
     * @param args
     * @author fjunkar
     * since 2022-12-02
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // checks if user is still inputting
        // and continues returning answer;
        // stops when user inputs "quit"
        boolean inputting = true;
        while (inputting) {
            String input = reader.nextLine();
            if (input.equals("quit")) {
                break;
            }
            System.out.println(produceAnswer(input));
        }
    }

    /**
     * accessor method that parses through
     * expression and gets parses first
     * fraction: checks for sign and
     * breaks it into whole, numerator,
     * and denominator
     * @param input the string input given
     *              by the user
     * @return String operator firstOperWhole firstOperNumer firstOperDenom
     */
    public static String parseFirstFrac(String input) {
        // breaks down input into first operand and operator
        String[] arr = input.split(" ");
        String firstOper = arr[0];
        String operator = arr[1];

        // checks if first operand has "_"
        if (firstOper.indexOf("_") != -1) {
            String[] firstOperArr = firstOper.split("_");
            int firstOperWhole = Integer.parseInt(firstOperArr[0]);
            String firstOperFraction = firstOperArr[1];

            // breaks first operand into whole, numerator, and denominator
            String[] firstOperFractionArr = firstOperFraction.split("/");
            int firstOperNumer = Integer.parseInt(firstOperFractionArr[0]);
            int firstOperDenom = Integer.parseInt(firstOperFractionArr[1]);

            // makes sure numerator is negative if fraction is negative
            if (firstOperWhole < 0) {
                firstOperNumer = -1 * firstOperNumer;
            }
            return operator + " " + firstOperWhole + " " + firstOperNumer + " " + firstOperDenom;
        }

        // process for if no "_" is found
        else {
            // checks if there is a "/"; if so, there is no whole number
            if (firstOper.indexOf("/") != -1) {
                int firstOperWhole = 0;

                String[] firstOperFractionArr = firstOper.split("/");
                int firstOperNumer = Integer.parseInt(firstOperFractionArr[0]);
                int firstOperDenom = Integer.parseInt(firstOperFractionArr[1]);
                return operator + " " + firstOperWhole + " " + firstOperNumer + " " + firstOperDenom;
            }
            // otherwise, the first fraction is a whole number; numerator is set to 0 and denominator is set to 1
            else {
                int firstOperWhole = Integer.parseInt(firstOper);
                int firstOperNumer = 0;
                int firstOperDenom = 1;
                return operator + " " + firstOperWhole + " " + firstOperNumer + " " + firstOperDenom;
            }
        }
    }

    /**
     * accessor method that parses through
     * expression and gets parses second
     * fraction: checks for sign and
     * breaks it into whole, numerator,
     * and denominator
     * @param input the string input given
     *              by the user
     * @return String operator secondOperWhole secondOperNumer secondOperDenom
     */
    public static String parseSecondFrac(String input) {
        // breaks down input into first operand,
        // operator, and second operand
        String[] arr = input.split(" ");
        String firstOper = arr[0];
        String operator = arr[1];
        String secondOper = arr[2];

        // checks if second operand has "_"
        if (secondOper.indexOf("_") != -1) {
            String[] secondOperArr = secondOper.split("_");
            int secondOperWhole = Integer.parseInt(secondOperArr[0]);
            String secondOperFraction = secondOperArr[1];

            // breaks second operand into whole, numerator, and denominator
            String[] secondOperFractionArr = secondOperFraction.split("/");
            int secondOperNumer = Integer.parseInt(secondOperFractionArr[0]);
            int secondOperDenom = Integer.parseInt(secondOperFractionArr[1]);

            // makes sure numerator is negative if fraction is negative
            if (secondOperWhole < 0) {
                secondOperNumer = -1 * secondOperNumer;
            }
            return operator + " " + secondOperWhole + " " + secondOperNumer + " " + secondOperDenom;
        }

        // process for if there is no "_"
        else {
            // checks if there is a "/"; if so, there is no whole number
            if (secondOper.indexOf("/") != -1) {
                int secondOperWhole = 0;

                String[] secondOperFractionArr = secondOper.split("/");
                int secondOperNumer = Integer.parseInt(secondOperFractionArr[0]);
                int secondOperDenom = Integer.parseInt(secondOperFractionArr[1]);
                return operator + " " + secondOperWhole + " " + secondOperNumer + " " + secondOperDenom;
            }

            // otherwise, the first fraction is a whole number; numerator is set to 0 and denominator is set to 1
            else {
                int secondOperWhole = Integer.parseInt(secondOper);
                int secondOperNumer = 0;
                int secondOperDenom = 1;
                return operator + " " + secondOperWhole + " " + secondOperNumer + " " + secondOperDenom;
            }
        }
    }

    /**
     * performs addition for two fraction inputs
     * @param input the string the user inputted
     * @return simplified final answer
     * @author fjunkar
     * @since 2022-12-02
     */
    public static String add(String input) {
        // takes second item in the string returned by parseFirstFrac
        // and makes it into an int whole1
        // similar operation to take int num1, int num2, int whole2, int num2,
        // and int den2 by parsing through return statements of previous methods
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        // operation to add the fractions
        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * den2 + num2 * den1;
        int den = den1 * den2;

        return simplify(num, den);
    }

    /**
     * performs subtraction for two fraction inputs
     * @param input the string the user inputted
     * @return simplified final answer
     * @author fjunkar
     * @since 2022-12-02
     */
    public static String subtract(String input) {
        // takes second item in the string returned by parseFirstFrac
        // and makes it into an int whole1
        // similar operation to take int num1, int num2, int whole2, int num2,
        // and int den2 by parsing through return statements of previous methods
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        // operation to subtract the fractions
        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * den2 - num2 * den1;
        int den = den1 * den2;

        return simplify(num, den);
    }

    /**
     * performs multiplication for two fraction inputs
     * @param input the string the user inputted
     * @return simplified final answer
     * @author fjunkar
     * @since 2022-12-02
     */
    public static String multiply(String input) {
        // takes second item in the string returned by parseFirstFrac
        // and makes it into an int whole1
        // similar operation to take int num1, int num2, int whole2, int num2,
        // and int den2 by parsing through return statements of previous methods
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        // operation to multiply fractions
        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * num2;
        int den = den1 * den2;

        return simplify(num, den);
    }

    /**
     * performs division for two fraction inputs
     * @param input the string the user inputted
     * @return simplified final answer
     * @author fjunkar
     * @since 2022-12-02
     */
    public static String divide(String input) {
        // takes second item in the string returned by parseFirstFrac
        // and makes it into an int whole1
        // similar operation to take int num1, int num2, int whole2, int num2,
        // and int den2 by parsing through return statements of previous methods
        int whole1 = Integer.parseInt(parseFirstFrac(input).split(" ")[1]);
        int num1 = Integer.parseInt(parseFirstFrac(input).split(" ")[2]);
        int den1 = Integer.parseInt(parseFirstFrac(input).split(" ")[3]);

        int whole2 = Integer.parseInt(parseSecondFrac(input).split(" ")[1]);
        int num2 = Integer.parseInt(parseSecondFrac(input).split(" ")[2]);
        int den2 = Integer.parseInt(parseSecondFrac(input).split(" ")[3]);

        // operation to divide the fractions
        num1 = whole1 * den1 + num1;
        num2 = whole2 * den2 + num2;

        int num = num1 * den2;
        int den = num2 * den1;

        return simplify(num, den);
    }

    /**
     * simplifies result given by add, subtract,
     * multiply, or divide method
     * @param num the numerator of the unsimplified improper fraction
     * @param denom the denominator of the unsimplified improper fraction
     * @return final simplified answer
     * @author fjunkar
     * @since 2022-12-02
     */
    public static String simplify(int num, int denom) {
        int numerator = num;
        int denominator = denom;

        // flips sign of both numerator and denominator to
        // make denominator positive (for ease of future calculations)
        if ((numerator > 0 && denominator < 0) || numerator < 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        // divides numerator and denominator by every integer
        // less than or equal to denominator repeatedly
        // until reaching 2
        for (int i = Math.abs(denominator); i > 1; i --) {
            while ((numerator % i == 0) && (denominator % i == 0)) {
                numerator /= i;
                denominator /= i;
            }
        }

        // if denominator has been simplified to 1,
        // return numerator as answer
        if (denominator == 1) {
            return "" + numerator;
        }

        // if numerator was 0 the whole time,
        // return answer as 0
        else if (numerator == 0) {
            return "0";
        }

        // procedure for normal cases that are now simplified
        // improper fractions after going through the for loop
        else {
            // in the case that the absolute value of the numerator
            // is greater than the absolute value of the denominator
            if (Math.abs(numerator) > Math.abs(denominator)) {
                // if numerator and denominator are divisible by each other,
                // return quotient of numerator and denominator (whole number)
                if ((Math.abs(numerator) % Math.abs(denominator)) == 0) {
                    return "" + numerator / denominator;
                }

                // otherwise,
                else {
                    return (numerator / denominator) + "_" + (Math.abs(numerator) % Math.abs(denominator)) + "/" + Math.abs(denominator);
                }
            }

            // otherwise, just print the numerator over the denominator
            // since they are simplified and numerator is greater than denominator
            else {
                return numerator + "/" + denominator;
            }
        }
    }

    public static String produceAnswer(String input) {
        // parses through input to find the operator
        String[] arr = input.split(" ");
        String firstOper = arr[0];
        String operator = arr[1];

        // if operator is "+," performs addition
        if (operator.equals("+")) {
            return add(input);
        }

        // if operator is "-," performs subtraction
        else if (operator.equals("-")) {
            return subtract(input);
        }

        // if operator is "*," performs multiplication
        else if (operator.equals("*")) {
            return multiply(input);
        }

        // otherwise it is assumed operator is "/," and performs division
        else {
            return divide(input);
        }
    }
}
