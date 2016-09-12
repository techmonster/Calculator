package holloway.nate.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class CalculatorTest {

    @Test
    public void addTest(){

    }

    @Test
    public void checkStateTest(){
        State newState = new State(State.Mode.CORE);

        State.Mode actual = newState.getStateValue();
        State.Mode expected = State.Mode.CORE;
        Assert.assertSame(expected,actual);
    }
}
