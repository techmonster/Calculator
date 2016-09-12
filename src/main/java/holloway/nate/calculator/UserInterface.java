package holloway.nate.calculator;

import java.util.Scanner;

/**
 * Created by nathanielholloway on 9/12/16.
 */
 class UserInterface {
    Scanner sc = new Scanner(System.in);
    CoreCalculator calculator = new CoreCalculator();
    Display newDisplay = new Display();
    State thisState = new State();



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
                System.out.println("Enter 'A' for addition, 'S' for subtraction" +
                        " 'M' to multiply, 'D' to divide\n" +
                        "'T' to square a number, 'X' to calculate variable exponentiation, 'R' to find the root" +
                        ", 'I' for the inverse of the number displayed, and 'Q' to quit ");
                getCoreCalculatorInput();
                break;
            case 2:
                System.out.println("What do you want to do?\n" +
                        "1) Basic math\n" +
                        "2) Scientific math");

                getScientificCalculatorInput();
                break;

        }
        System.out.println();

    }

    double getCoreCalculatorInput(){
        String userSelection;
        double num1;
        double num2;
        double answer = 0;
        userSelection = sc.next();
        switch (userSelection.toUpperCase().charAt(0)){
            case('A'):
                System.out.println("Please select two numbers you want to add..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.add(num1,num2);
                break;
            case('S'):
                System.out.println("Please select two numbers you want to subtract..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.subtract(num1,num2);
                break;
            case('M'):
                System.out.println("Please select two numbers you want to multiply..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.multiply(num1,num2);
                break;
            case('D'):
                System.out.println("Please select two numbers you want to divide..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.divide(num1,num2);
                break;
            case('T'):
                System.out.println("Please select the number you want to square..");
                num1 = sc.nextDouble();
                answer = calculator.square(num1);
                break;
            case('R'):
                System.out.println("Please select the number you want the root of..");
                num1 = sc.nextDouble();
                answer = calculator.root(num1);
                break;
            case('X'):
                System.out.println("Please select two numbers, the number, then it's exponent..");
                num1 = sc.nextDouble();
                num2 = sc.nextDouble();
                answer = calculator.exponent(num1,num2);
                break;
            case('Q'):
                break;
            default:
                System.out.println("Please select a valid choice.");
                getCoreCalculatorInput();
        }

        print(answer);
        return answer;
    }

    double getScientificCalculatorInput(){
        double thisDouble = 0;



        print(thisDouble);
        return thisDouble;
    }

    void print(double answer){

        newDisplay.print("Answer: "+answer);
    }
}
