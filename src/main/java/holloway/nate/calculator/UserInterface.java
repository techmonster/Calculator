package holloway.nate.calculator;

import java.util.Scanner;

/**
 * Created by nathanielholloway on 9/12/16.
 * The user interface for my calculator.
 */
 class UserInterface {
    private Scanner sc;
    private CoreCalculator calculator;
    private ScientificCalculator scientificCalculator;
    private Display newDisplay;
    private State thisState;
    private Memory memory;
    private int count;
    public boolean quit = false;
    private String programGreeting = "What do you want to do?\n" +
            "1) Basic math\n" +
            "2) Scientific math\n" +
            "3) Quit";

    public UserInterface() {
        sc = new Scanner(System.in);
        calculator = new CoreCalculator();
        scientificCalculator = new ScientificCalculator();
        newDisplay = new Display();
        thisState = new State();
        memory = new Memory();
        count = 0;
    }

    int drawMenu() {
        int userSelection;
        newDisplay.print(programGreeting);
        userSelection = sc.nextInt();
        if (userSelection != 1 && userSelection != 2 && userSelection != 3) {
            drawMenu();
        }

        if (userSelection == 3) {
            thisState.setStateValue(3);
        }

        return userSelection;
    }

    void drawMenu(int i) {

        switch (i) {
            case 1:
                getCoreCalculatorAnswers();
                break;
            case 2:
                getScientificCalculatorAnswers();
                break;

        }
        System.out.println();

    }

    private void getCoreCalculatorAnswers() {
        ScientificCalculator.DisplayMode thisMode = scientificCalculator.currentDisplayMode;
        int response;
        Character userSelection;
        String displayModeAnswer="";
        double answer = 0;
        int pressedEnter = 1;

        newDisplay.print(calculator.greeting);
        userSelection = sc.next().toUpperCase().charAt(0);
        answer = switchCoreFunctions(userSelection);
        print(answer);

        newDisplay.print("Do you want to switch your display?\n'Y' or 'N'");
        displayModeAnswer = sc.next();
        if(displayModeAnswer.toUpperCase().equals("Y")){
            newDisplay.print("Do you want to 1)Cycle through options or \nAny other number to Enter a string?");
            response = sc.nextInt();
            if(response==1){
                while (pressedEnter == 1) {
                    newDisplay.print("Press 1) to cycle \nAny other number to quit");
                    thisMode = scientificCalculator.switchDisplayMode();
                    newDisplay.print(thisMode.toString());
                    pressedEnter = sc.nextInt();
                }
            }else {
                newDisplay.print("Enter Binary, Octal, Decimal or Hex");
                displayModeAnswer = sc.next();
                thisMode = scientificCalculator.switchDisplayMode(displayModeAnswer);
            }
            getAnswerInDisplayMode(thisMode, answer);
            }
        else {
            displayModeAnswer = ScientificCalculator.DisplayMode.DECIMAL.toString();
            getAnswerInDisplayMode(scientificCalculator.switchDisplayMode(displayModeAnswer), answer);

        }
        //print(answer);
    }

    private void getScientificCalculatorAnswers() {
        String userSelection;
        double answer = 0;
        quit = false;
        int memoryAnswer = 4;

                newDisplay.print(calculator.greeting);
                newDisplay.print(scientificCalculator.greeting);
                userSelection = sc.next();

                if (Character.isDigit(userSelection.charAt(0))){

                    answer = switchScientificFunctions(Integer.valueOf(userSelection));
                    print(answer);
                    memory.getDisplayValue();
                    while(memoryAnswer!=2) {
                        newDisplay.print("Do you want to change the Trig display mode?\n 1)Yes\n 2)NO ");
                        memoryAnswer = sc.nextInt();
                        if(memoryAnswer==1){
                            scientificCalculator.switchUnitsMode();
                            answer = scientificCalculator.currentUnitsMode.equals(ScientificCalculator.UnitsMode.DEGREES) ?  Math.toRadians(answer): Math.toDegrees(answer);
                            newDisplay.print(scientificCalculator.currentUnitsMode.toString());
                            print(answer);
                        }
                    }
                }
                else{
                    answer = switchCoreFunctions(userSelection.toUpperCase().charAt(0));
                    print(answer);

                }

        newDisplay.print(memory.getMemoryOperationsPrompt());
        memoryAnswer = sc.nextInt();
        determineMemoryOperations(memoryAnswer);
    }

    private double switchCoreFunctions(Character function) {
                double num1;
                double num2;
                double answer = 0;

        switch (function) {
            case ('A'):
                newDisplay.print("Please select two numbers you want to add..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.add(num1, num2);
                break;
            case ('C'):
                newDisplay.clearScreen();
                break;
            case ('S'):
                newDisplay.print("Please select two numbers you want to subtract..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.subtract(num1, num2);
                break;
            case ('M'):
                newDisplay.print("Please select two numbers you want to multiply..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.multiply(num1, num2);
                break;
            case ('D'):
                newDisplay.print("Please select two numbers you want to divide..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.divide(num1, num2);
                break;
            case ('T'):
                newDisplay.print("Please select the number you want to square..");
                num1 = sc.nextDouble();
                answer = calculator.square(num1);
                break;
            case ('R'):
                newDisplay.print("Please select the number you want the root of..");
                num1 = sc.nextDouble();
                answer = calculator.root(num1);
                break;
            case ('X'):
                newDisplay.print("Please select two numbers, the number, then it's exponent..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.exponent(num1, num2);
                break;
            case ('Q'):
                quit = true;
                break;
            default:
                newDisplay.print("Please select a valid choice.");
                getCoreCalculatorAnswers();

        }
                storeCurrentNumber(answer);

        return answer;
    }

    private double switchScientificFunctions(int functions){
        double answer = 0;
        String displayAnswer = "";
        double num1;

        while(answer!=2.0) {
            newDisplay.print("Do you want to change the Trig display mode?\n 1)Yes\n 2)NO ");
            answer = sc.nextDouble();
            if (answer == 1.0) {
                newDisplay.print(scientificCalculator.getUnitsModeMsg());
                newDisplay.print("Type 'Degrees' or 'Radians' ");
                displayAnswer = sc.next();
                newDisplay.changeTrigDisplay(displayAnswer);
            }
        }
        newDisplay.changeTrigDisplay(scientificCalculator.getUnitsModeMsg());
        switch(functions){
            case 1:
                newDisplay.print("Please enter a number to determine it's sine");
                num1 = sc.nextDouble();
                answer = scientificCalculator.sine(num1);
                break;
            case 2:
                newDisplay.print("Please enter a number to determine it's cosine");
                num1 = sc.nextDouble();
                answer = scientificCalculator.cosine(num1);
                break;
            case 3:
                newDisplay.print("Please enter a number to determine it's tangent");
                num1 = sc.nextDouble();
                answer = scientificCalculator.tangent(num1);
                break;
            case 4:
                newDisplay.print("Please enter a number to determine it's inverse sine");
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseSine(num1);
                break;
            case 5:
                newDisplay.print("Please enter a number to determine it's inverse cosine");
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseCosine(num1);
                break;
            case 6:
                newDisplay.print("Please enter a number to determine it's inverse tangent");
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseTangent(num1);
                break;
            case 7:
                newDisplay.print("Please enter a number to determine it's log");
                num1 = sc.nextDouble();
                answer = scientificCalculator.log(num1);
                break;
            case 8:
                newDisplay.print("Please enter a number to determine it's inverse log");
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseLog(num1);
                break;
            case 9:
                newDisplay.print("Please enter a number to determine it's natural log");
                num1 = sc.nextDouble();
                answer = scientificCalculator.naturalLog(num1);
                break;
            case 10:
                newDisplay.print("Please enter a number to determine it's inverse natural log");
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseNaturalLog(num1);
                break;
            case 11:
                newDisplay.print("Please enter a number to determine it's factorial");
                num1 = sc.nextDouble();
                answer = scientificCalculator.factorial((int)num1);
                break;
            case 12:
                newDisplay.print("Please enter a number to find it's cube. ");
                num1 = sc.nextDouble();
                answer = scientificCalculator.cube(num1);
                break;
            case 13:
                newDisplay.print("Please enter a number to find it's cube root.");
                num1 = sc.nextDouble();
                answer = scientificCalculator.cubeRoot(num1);
                break;
            case 14:
                newDisplay.print("Back to main menu.");
                break;
            default:
                newDisplay.print("Invalid value");


        }
        storeCurrentNumber(answer);
        return answer;
    }

    private void print(double answer) {

        newDisplay.print("Answer: " + answer);
    }

    private void storeCurrentNumber(double currentNumber) {
        memory.setDisplayValue(currentNumber);
    }

    private void determineMemoryOperations(int memoryOperation) {
        switch (memoryOperation) {
            case 1:
                memory.MPlus();
                break;
            case 2:
                memory.MClear();
                break;
            case 3:
                memory.MRecall();
                break;
            default:
                break;
        }
    }

    private void getAnswerInDisplayMode(ScientificCalculator.DisplayMode mode, Double answer){

        switch (mode){
            case BINARY:
                newDisplay.print(Integer.toBinaryString((int)Math.round(answer)));
                break;
            case OCTAL:
                newDisplay.print(Integer.toOctalString((int)Math.round(answer)));
            break;
            case DECIMAL:
                print(answer);
                break;
            case HEX:
                newDisplay.print(Integer.toHexString((int)Math.round(answer)));
                break;
            default:
                print(answer);
        }

    }

}


