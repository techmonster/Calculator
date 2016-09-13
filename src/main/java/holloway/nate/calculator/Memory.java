package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class Memory {

    private double displayValue;
    private double memoryValue;

    public Memory(){
        displayValue = 0;
        memoryValue = 0;
    }

    public double getDisplayValue(){
        return displayValue;
    }
    public void setDisplayValue(double displayValue){
        this.displayValue = displayValue;
    }

    public void setMemoryValue(double memoryValue){
        this.memoryValue = memoryValue;
    }

    public void resetMemoryValue(){
        memoryValue = 0;
    }

    public void setDisplayValueToMemoryValue(){
        displayValue = memoryValue;
    }

    public void resetDisplayValue(){
        displayValue = 0;
    }
}
