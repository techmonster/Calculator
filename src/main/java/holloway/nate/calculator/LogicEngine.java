package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
 class LogicEngine {
    private State state;
    private Controller ui;

    LogicEngine(){
        state = new State(State.Mode.CORE);
        ui = new Controller();
    }

    void start(){
        int userSelection = 1;
        boolean keepGoing = true;
        while(keepGoing) {
            userSelection = ui.drawMenu();      //user selects an option basic math, scientific math, or quit
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
