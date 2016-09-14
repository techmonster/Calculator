package holloway.nate.calculator;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class Memory {

    private double displayValue;
    private double memoryValue;
    private static String memoryOperations= " Select 1)For 'M+' to add to currently displayed value to the value in memory." +
            "\n Select 2)For 'MC' to clear memory\n Select 3)For 'MRC' to display current memory value\n Press any other number to continue " +
            "without using memory";

    private Display calcDisplay;
    public Memory(){
        displayValue = 0;
        memoryValue = 0;
        calcDisplay = new Display();
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

    public String getMemoryOperationsPrompt() {
        return memoryOperations;
    }

    public void MPlus(){
        memoryValue += getDisplayValue();
        setDisplayValue(memoryValue);
        calcDisplay.print(""+memoryValue);
    }
    public void MClear(){
        resetMemoryValue();
        calcDisplay.print("0");
    }

    public void MRecall(){
        setDisplayValueToMemoryValue();
        calcDisplay.print(""+displayValue);
    }
}
