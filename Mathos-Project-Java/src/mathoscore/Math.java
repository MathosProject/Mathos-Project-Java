package mathoscore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This class provides you with basic math functions.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 * @author Artem Los (arteml@kth.se), Mathos Project.
 */
public class Math {

    public static double round(double value, int places) {
        if(places < 0)
            throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);

        return bd.doubleValue();
    }

    public static double truncate(double value) {
        DecimalFormat format = new DecimalFormat("#");
        format.setRoundingMode(RoundingMode.HALF_UP);

        return Double.parseDouble(format.format(value));
    }
}
