package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class CoreCalculator {


    double add(double number1 ,double number2){
        double newNumber = number1 + number2;
        return newNumber;
    }

    double subtract(double number1, double number2){
        double newNumber = number1 - number2;
        return newNumber;
    }

    double multiply(double number1, double number2){
        double newNumber = number1 * number2;
        return newNumber;
    }

    double divide(double number1, double number2){
        double newNumber = 0;
        try {
            newNumber = number1 / number2;
        }
        catch (ArithmeticException a){
            System.out.println(a);
        }

        return newNumber;
    }

    double square(double number1){
        double newNumber = number1 * number1;
        return newNumber;
    }

    double root(double number1){
        double newNumber = Math.sqrt(number1);
        return newNumber;
    }

    double exponent(double number1, double number2){
        double newNumber = Math.pow(number1,number2);
        return newNumber;
    }

}
