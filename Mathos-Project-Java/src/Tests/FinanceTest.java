package tests;

import mathoscore.Finance;
import org.junit.Test;

import java.math.BigDecimal;

public class FinanceTest {

    @Test
    public void futureValueTest() {
        System.out.println(Finance.futureValue(new BigDecimal(100), new BigDecimal(6), 4));
    }

    @Test
    public void presentValueTest() {
        System.out.println(Finance.presentValue(new BigDecimal(100), new BigDecimal(6), 4));
    }
}
