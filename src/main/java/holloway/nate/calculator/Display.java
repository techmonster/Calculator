package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class Display {

    ScientificCalculatorModel unitsMode = new ScientificCalculatorModel();

    public void print(String newString){

        System.out.println(newString);
    }

    public void clearScreen(){

        System.out.println("0");
    }

    public void changeTrigDisplay(){

        unitsMode.switchUnitsMode();
    }

    public void changeTrigDisplay(String mode){
        unitsMode.switchUnitsMode(mode);
    }



}
