package tests.calculus;

import org.junit.Test;
import mathos.calculus.IntegralCalculus;

public class IntegralCalculusTest {

    @Test
    public void integration() {
        double integration = IntegralCalculus.Integrate(x -> x * x, 0, 10, IntegralCalculus.IntegrationAlgorithm.RectangleMethod);

        System.out.println(integration);
    }

    @Test
    public void integration2() {
        double integration = IntegralCalculus.Integrate(x -> x * x, 0, 10, IntegralCalculus.IntegrationAlgorithm.TrapezoidalRule);

        System.out.println(integration);
    }

    @Test
    public void integration3() {
        double integration = IntegralCalculus.Integrate(x -> x * x, 0, 10, IntegralCalculus.IntegrationAlgorithm.SimpsonsRule);

        System.out.println(integration);
    }
}
