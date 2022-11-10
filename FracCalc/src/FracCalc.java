import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner reader = new Scanner(System.in);
        boolean inputting = true;
        while (inputting) {
            String input = reader.nextLine();
            System.out.println(produceAnswer(input));
            if (input == "quit") {
                inputting = false;
            }
        }


    }

    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
        String[] arr = input.split(" ");
        String firstOper = arr[0];
        String operator = arr[1];
        String secondOper = arr[2];

        String[] secondOperWholeArr = secondOper.split("_");
        String secondOperWhole = secondOperWholeArr[0];
        String secondOperFraction = secondOperWholeArr[1];

        String[] secondOperNumArr = secondOperFraction.split("/");
        String secondOperNum = secondOperNumArr[0];

        String secondOperDen = secondOperNumArr[1];

        return ("whole:" + secondOperWhole + " numerator:" + secondOperNum + " denominator:" + secondOperDen);
    }
}
