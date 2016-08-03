package tests;

import mathos.statistics.DiceSimulator;
import org.junit.Test;

public class DiceTest {

    @Test
    public void rollTest() {
        DiceSimulator d = new DiceSimulator(6);

        System.out.println(d.toString());
    }
}
