package holloway.nate.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/12/16.
 */
public class CalculatorTest {

    @Test
    public void addTest(){
        CoreCalculatorModel calculator = new CoreCalculatorModel();
        double actual = calculator.add(4,60);
        double expected = 64;
        Assert.assertSame("These two should be the same",expected,actual);

    }

    @Test
    public void checkStateTest(){
        State newState = new State(State.Mode.CORE);

        State.Mode actual = newState.getStateValue();
        State.Mode expected = State.Mode.CORE;
        Assert.assertSame(expected,actual);
    }

    @Test
    public void subtractTest(){
        CoreCalculatorModel calculator = new CoreCalculatorModel();
        double actual = calculator.subtract(40,6);
        double expected = 34;
        Assert.assertSame("These two should be the same",expected,actual);

    }
}
