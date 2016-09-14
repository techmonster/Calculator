package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */

public class CoreCalculatorModel {

    static int displayMode = 0;
    double newNumber;
    String greeting = "Enter 'A' for addition, 'S' for subtraction" +
            " 'M' to multiply, 'D' to divide\n" +
            "'T' to square a number, 'X' to calculate variable exponentiation, 'R' to find the root\n" +
            ", 'I' for the inverse of the number displayed, 'C' to clear the screen, and 'Q' to quit ";

    public enum DisplayMode{BINARY, OCTAL, DECIMAL, HEX}    //Probably should be move to State class
    DisplayMode currentDisplayMode;

    public CoreCalculatorModel(){

    }

    DisplayMode switchDisplayMode(){

        displayMode = displayMode % 4 +1;
        switch (displayMode){
            case 1:
                currentDisplayMode = DisplayMode.BINARY;
                break;
            case 2:
                currentDisplayMode = DisplayMode.OCTAL;
                break;
            case 3:
                currentDisplayMode = DisplayMode.DECIMAL;
                break;
            case 4:
                currentDisplayMode = DisplayMode.HEX;
                break;
        }
        return currentDisplayMode;
    }

    DisplayMode switchDisplayMode(String mode){

        switch (mode.toUpperCase().charAt(0)){
            case 'B':
                currentDisplayMode = DisplayMode.BINARY;

                break;
            case 'O':
                currentDisplayMode = DisplayMode.OCTAL;
                break;
            case 'D':
                currentDisplayMode = DisplayMode.DECIMAL;
                break;
            case 'H':
                currentDisplayMode = DisplayMode.HEX;
                break;
            default:
                currentDisplayMode = DisplayMode.DECIMAL;
        }
        return currentDisplayMode;
    }

    double add(double number1 ,double number2){newNumber = number1 + number2; return newNumber;}

    double subtract(double number1, double number2){newNumber = number1 - number2; return newNumber;}

    double multiply(double number1, double number2){newNumber = number1 * number2; return newNumber;}

    double divide(double number1, double number2){
        newNumber = 0;

        try {
            newNumber = number1 / number2;
        }
        catch (ArithmeticException a){
            System.out.println(a);
        }
        return newNumber;
    }

    double square(double number1){newNumber = number1 * number1; return newNumber;}

    double root(double number1){newNumber = Math.sqrt(number1); return newNumber;}

    double exponent(double number1, double number2){newNumber = Math.pow(number1,number2); return newNumber;}
}



