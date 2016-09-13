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

    public UserInterface(){
        sc = new Scanner(System.in);
        calculator = new CoreCalculator();
        scientificCalculator = new ScientificCalculator();
        newDisplay = new Display();
        thisState= new State();
        memory = new Memory();
    }

    int drawMenu(){
        int userSelection;
        System.out.println("What do you want to do?\n" +
                "1) Basic math\n" +
                "2) Scientific math\n" +
                "3) Quit");
        userSelection = sc.nextInt();
        if(userSelection != 1 && userSelection != 2 && userSelection != 3){
            drawMenu();
        }

        if (userSelection == 3)
        {
            thisState.setStateValue(3);
        }

        return userSelection;
    }

     void drawMenu(int i){

        switch(i){
            case 1:
                newDisplay.print(calculator.greeting);
                getCoreCalculatorInput();
                break;
            case 2:
                newDisplay.print(scientificCalculator.greeting);
                getScientificCalculatorInput();
                break;

        }
        System.out.println();

    }

    private double getCoreCalculatorInput(){
        String userSelection;
        double num1;
        double num2;
        double answer = 0;
        userSelection = sc.next();
        switch (userSelection.toUpperCase().charAt(0)){
            case('A'):
                newDisplay.print("Please select two numbers you want to add..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.add(num1,num2);
                break;
            case('S'):
                newDisplay.print("Please select two numbers you want to subtract..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.subtract(num1,num2);
                break;
            case('M'):
                newDisplay.print("Please select two numbers you want to multiply..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.multiply(num1,num2);
                break;
            case('D'):
                newDisplay.print("Please select two numbers you want to divide..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.divide(num1,num2);
                break;
            case('T'):
                newDisplay.print("Please select the number you want to square..");
                num1 = sc.nextDouble();
                answer = calculator.square(num1);
                break;
            case('R'):
                newDisplay.print("Please select the number you want the root of..");
                num1 = sc.nextDouble();
                answer = calculator.root(num1);
                break;
            case('X'):
                newDisplay.print("Please select two numbers, the number, then it's exponent..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.exponent(num1,num2);
                break;
            case('Q'):
                break;
            default:
                newDisplay.print("Please select a valid choice.");
                getCoreCalculatorInput();
        }

        print(answer);
        storeCurrentNumber(answer);
        return answer;
    }

    private double getScientificCalculatorInput(){
        int userSelection;
        String msg = "Please select a number..";
        double num1;
        double answer = 0;
        userSelection = sc.nextInt();
        switch (userSelection){
            case(1):
                newDisplay.print(msg+" to get the sine");
                num1 = sc.nextDouble();
                answer = scientificCalculator.sine(num1);
                break;
            case(2):
                newDisplay.print(msg+"");
                num1 = sc.nextDouble();
                answer = scientificCalculator.cosine(num1);
                break;
            case(3):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.tangent(num1);
                break;
            case(4):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseSine(num1);
                break;
            case(5):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseCosine(num1);
                break;
            case(6):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseTangent(num1);
                break;
            case(7):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.log(num1);
                break;
            case(8):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseLog(num1);
                break;
            case(9):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.naturalLog(num1);
                break;
            case(10):
                newDisplay.print(msg);
                num1 = sc.nextDouble();
                answer = scientificCalculator.inverseNaturalLog(num1);
                break;
            case(11):
                newDisplay.print("Enter a number to get a factorial");
                num1 = sc.nextDouble();
                answer = scientificCalculator.factorial((int)num1);
                break;
            case(12):
                break;
            default:
                newDisplay.print("Please select a valid choice.");
                getScientificCalculatorInput();
        }

        storeCurrentNumber(answer);
        print(answer);
        return answer;
    }

    private void print(double answer){

        newDisplay.print("Answer: "+answer);
    }

    private void storeCurrentNumber(double currentNumber){
        memory.setDisplayValue(currentNumber);
    }


}
