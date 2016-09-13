package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class ScientificCalculator {

    public enum DisplayMode{BINARY, OCTAL, DECIMAL, HEX}
    DisplayMode currentMode;
    String greeting;

    ScientificCalculator() {
        currentMode = DisplayMode.DECIMAL;
         greeting = "Enter '1')Sine, 2)Cosine, 3)Tangent, 4)Inverse Sine, 5)Inverse Cosine, 6)Inverse Tangent, " +
                "\n7)Log, 8)Inverse Log, 9)Natural Log, 10)Inverse Natural Log, 11)Factorial, 12)Quit ";
    }

    double sine(double x){
        return Math.sin(x);
    }

    double cosine(double x){
        return Math.cos(x);
    }
    double tangent(double x){
        return Math.tan(x);
    }
    double inverseSine(double x){
        return Math.asin(x);
    }
    double inverseCosine(double x){
        return Math.acos(x);
    }
    double inverseTangent(double x){
        return Math.atan(x);
    }
    double log(double x){
        return Math.log(x);
    }
    double inverseLog(double x){
        return Math.pow(10,x);
    }
    double naturalLog(double x){
        return Math.log(x);
    }
    double inverseNaturalLog(double x){
        return Math.exp(x);
    }
    double factorial(int number){

        int answer = 0;
        for (int i = 0; i <= number; i++) {
            answer += i;
        }
        return answer;
    }
}
