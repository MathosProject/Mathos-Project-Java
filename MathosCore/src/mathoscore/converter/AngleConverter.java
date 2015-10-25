package mathoscore.converter;

/**
 * This class provides you with tools for performing angle conversions.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 * @author Artem Los (arteml@kth.se), Mathos Project.
 */
public class AngleConverter {

    /**
     * Returns angle imputed as "degrees.minutesseconds" in to decimal degree.
     * @param angle Angle to be converted to decimal degree.
     * @return angle imputed as "degrees.minutesseconds" in to decimal degree.
     */
    public static double angleToDecimalAngle(double angle) {
        double degrees = mathoscore.Math.truncate(angle);
        double minutes = mathoscore.Math.truncate((angle - degrees) * 100);
        double decimalMinutes = minutes / 60;
        double seconds = mathoscore.Math.round((((angle * 100) - mathoscore.Math.truncate(angle * 100)) * 100), 0);
        double decimalSeconds = seconds / 3600;

        return degrees + decimalMinutes + decimalSeconds;
    }

    /**
     * Returns angle imputed as decimal degree in to degree ("degree.minutesseconds").
     * @param angle Angle to be converted to degree.
     * @return angle imputed as decimal degree in to degree ("degree.minutesseconds").
     */
    public static double decimalAngleToAngle(double angle) {
        double degrees = mathoscore.Math.truncate(angle);
        double decimalMinutesAndSeconds = angle - degrees;
        double minutes = mathoscore.Math.truncate(decimalMinutesAndSeconds * 60);
        double seconds = mathoscore.Math.round((((decimalMinutesAndSeconds * 60) - minutes) * 60), 0);

        String stringDegrees = String.valueOf(degrees);
        String stringMinutes = String.valueOf(minutes);
        String stringSeconds = String.valueOf(seconds);

        if(minutes < 0)
            stringMinutes = String.valueOf(Double.parseDouble(stringMinutes) * (-1));
        if(minutes < 10 && minutes >= 0)
            stringMinutes = "0" + stringMinutes;
        if(Double.valueOf(stringSeconds) < 0)
            stringSeconds = String.valueOf(Double.parseDouble(stringSeconds) * (-1));
        if(Double.valueOf(stringSeconds) < 10 && Double.valueOf(stringSeconds) >= 0)
            stringSeconds = "0" + stringSeconds;

        String ugaoB = stringDegrees + "." + stringMinutes + stringSeconds;
        angle = mathoscore.Math.round(Double.parseDouble(ugaoB), 4);

        return angle;
    }

    /**
     * Returns angle imputed as "degrees.minutesseconds" in to radians.
     * @param angle Angle to be converted to radians.
     * @return angle imputed as "degrees.minutesseconds" in to radians.
     */
    public static double angleToRadians(double angle) {
        angle = angleToDecimalAngle(angle);

        return angle * Math.PI / 180;
    }

    /**
     * Returns angle imputed as radians in to decimal degrees.
     * @param angle Angle to be converted to decimal degrees.
     * @return angle imputed as radians in to decimal degrees
     */
    public static double radiansToDecimalAngle(double angle) {
        return angle * 180 / Math.PI;
    }

    /**
     * Returns angle imputed as radians in to decimal degrees.
     * @param angle Angle to be converted to decimal degrees.
     * @return angle imputed as radians in to decimal degrees.
     */
    public static double radiansToAngle(double angle) {
        angle = angle * 180 / Math.PI;
        angle = decimalAngleToAngle(angle);

        return angle;
    }
}
