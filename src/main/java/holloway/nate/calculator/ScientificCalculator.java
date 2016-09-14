package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class ScientificCalculator extends CoreCalculator{

    static int displayMode = 0;

    public enum DisplayMode{BINARY, OCTAL, DECIMAL, HEX}
    DisplayMode currentDisplayMode;

    public enum UnitsMode{DEGREES, RADIANS}
    UnitsMode currentUnitsMode;
    static int unitsMode = 0;
    String unitsModeMsg;
    String greeting;

    ScientificCalculator() {
        currentDisplayMode = DisplayMode.DECIMAL;
        currentUnitsMode = UnitsMode.DEGREES;
        unitsModeMsg = "How would you like this displayed?";

         greeting = "Enter '1')Sine, 2)Cosine, 3)Tangent, 4)Inverse Sine, 5)Inverse Cosine, 6)Inverse Tangent, " +
                "\n7)Log, 8)Inverse Log, 9)Natural Log, 10)Inverse Natural Log, 11)Factorial, 12)Quit ";
    }

    double sine(double x){return Math.sin(x);}

    double cosine(double x){return Math.cos(x);}

    double tangent(double x){return Math.tan(x);}

    double inverseSine(double x){return Math.asin(x);}

    double inverseCosine(double x){return Math.acos(x);}

    double inverseTangent(double x){return Math.atan(x);}

    double log(double x){return Math.log(x);}

    double inverseLog(double x){return Math.pow(10,x);}

    double naturalLog(double x){return Math.log(x);}

    double inverseNaturalLog(double x){return Math.exp(x);}

    double cube(double x){return x*x*x;}

    double cubeRoot(double x){return Math.cbrt(x);}

    double factorial(int number){

        int answer = 0;
        for (int i = 0; i <= number; i++) {
            answer += i;
        }
        return answer;
    }

    DisplayMode switchDisplayMode(){

        displayMode=displayMode%4+1;
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
                currentDisplayMode = DisplayMode.BINARY;
        }
        return currentDisplayMode;
    }

    UnitsMode switchUnitsMode(){

        if(unitsMode==1){
            unitsMode=2;
        }else {
            unitsMode=1;
        }

        switch(unitsMode){
            case 1:
                currentUnitsMode = UnitsMode.DEGREES;
                break;
            case 2:
                currentUnitsMode = UnitsMode.RADIANS;
        }
        return currentUnitsMode;
    }

    boolean switchUnitsMode(String mode){

        boolean success = true;
        switch (mode.toUpperCase().charAt(0)){
            case 'D':
                currentUnitsMode = UnitsMode.DEGREES;
                break;
            case 'R':
                currentUnitsMode = UnitsMode.RADIANS;
                break;
            default:
                success = false;
        }
        return success;
    }

    String getUnitsModeMsg(){
        return unitsModeMsg;
    }
}
