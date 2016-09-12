package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
 class LogicEngine {
    CoreCalculator calc;
    Display display;
    Memory memory;
    ScientificCalculator scientificCalculator;
    State state;
    UserInterface ui;

    LogicEngine(){
        calc = new CoreCalculator();
        display = new Display();
        memory = new Memory();
        scientificCalculator = new ScientificCalculator();
        state = new State(State.Mode.CORE);
        ui = new UserInterface();
    }

    void start(){
        int userSelection = 1;
        boolean keepGoing = true;
        while(keepGoing) {
            userSelection = ui.drawMenu();
            state.setStateValue(userSelection);
            ui.drawMenu(userSelection);

            keepGoing = checkState();
        }
    }

    boolean checkState(){
        boolean go = true;
        if (state.getStateValue()== State.Mode.QUIT){
            go = false;
        }
        return go;
    }
}
