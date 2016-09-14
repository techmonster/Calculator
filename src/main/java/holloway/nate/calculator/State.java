package holloway.nate.calculator;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class State {

    enum Mode{CORE, SCIENTIFIC, QUIT}
    Mode mode;


    State(){}
    State(Mode mode){
        this.mode = mode;
    }


    Mode getStateValue(){

        return mode ;
    }

    void setStateValue(int  userSelection){

        switch (userSelection){
            case 1:
            mode=Mode.CORE;
                System.out.println(mode.toString());
                break;
            case 2:
            mode = Mode.SCIENTIFIC;
                System.out.println(mode.toString());
                break;
            case 3:
                mode = Mode.QUIT;
                break;
        }

    }
}
