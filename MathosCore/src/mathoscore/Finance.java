package mathoscore;

import java.math.BigDecimal;

public class Finance {

	/**
	 * Calculates the future value of the <paramref name="presentValue"/> for a specified <paramref name="rateOfReturn"/> over <paramref name="numberOfPeriods"/> periods.
	 * @param presentValue Present value (ex 100).
	 * @param rateOfReturn Rate of return (ex 6 for 6%)
	 * @param numberOfPeriods Number of periods
	 * @return Future value
	 */
    public static BigDecimal futureValue(BigDecimal presentValue, BigDecimal rateOfReturn, int numberOfPeriods)
    {
        return presentValue.multiply(decimalPower((new BigDecimal(1).add(rateOfReturn.divide(new BigDecimal(100)))), numberOfPeriods));
    }
    
    /**
     * Calculates the present value of the <paramref name="futureValue"/> for a specified <paramref name="rateOfReturn"/> over <paramref name="numberOfPeriods"/> periods.
     * @param futureValue Future value (ex 100)
     * @param rateOfReturn Rate of return (ex 6 for 6%)
     * @param numberOfPeriods Number of periods
     * @return Present value
     */
    public static BigDecimal presentValue(BigDecimal futureValue, BigDecimal rateOfReturn, int numberOfPeriods)
    {
        return futureValue.divide(decimalPower((new BigDecimal(1).add(rateOfReturn.divide(new BigDecimal(100)))), numberOfPeriods), BigDecimal.ROUND_UP);
    }

    /// <summary>
    /// Calculates the net present value for an investment with multiple case flows over equi-distant time intervals at a given rate of return
    /// </summary>
    /// <param name="initialInvestment">Initial investment (ex 10000)</param>
    /// <param name="cashFlow">List of expected cash flows from investment (ex 200, 100, 300)</param>
    /// <param name="rateOfReturn">Expected rate of return (ex 5 for 5%)</param>
    /// <param name="round">Determines whether the result is rounded to 2 decimal places</param>
    /// <returns>Net present value</returns>
    
    /**
     * 
     * @param initialInvestment
     * @param cashFlow
     * @param rateOfReturn
     * @param round
     * @return
     */
/*    public static BigDecimal NetPresentValue(BigDecimal initialInvestment, HashSet<BigDecimal> cashFlow, BigDecimal rateOfReturn)
    {
        //var netPresentValue = initialInvestment*-1 + cashFlow.Select((t, i) => t/DecimalPower(1 + rateOfReturn/100, i + 1)).Sum(temp => round ? Math.Round(temp, 2) : temp);
    	//find a replacement for select.
    	BigDecimal netPresentValue = initialInvestment.multiply(new BigDecimal(1)) + cashFlow.Select ((t, i) -> t/DecimalPower(1 + rateOfReturn/100, i + 1)).Sum(temp -> round ? Math.Round(temp, 2) : temp);

        return round ? Math.Round(netPresentValue, 2) : netPresentValue;
    }*/

    /// <summary>
    /// Calculates the present value of an annuity
    /// </summary>
    /// <param name="periodicPayment">Periodic payment amount of annuity</param>
    /// <param name="ratePerPeriod">Rate per period</param>
    /// <param name="numberOfPeriods">Number of periods</param>
    /// <param name="round">Determines whether the result is rounded to 2 decimal places</param>
    /// <returns>Present value of annuity</returns>
/*    public static decimal PresentValueOfAnnuity(decimal periodicPayment, decimal ratePerPeriod, int numberOfPeriods, bool round = true)
    {
        var presentValueOfAnnuity = periodicPayment * ((1 - DecimalPower((1 + ratePerPeriod / 100), numberOfPeriods * -1)) / (ratePerPeriod / 100));

        return round ? Math.Round(presentValueOfAnnuity, 2) : presentValueOfAnnuity;
    }
*/
    /// <summary>
    /// Calculates the future value of an annuity
    /// </summary>
    /// <param name="periodicPayment">Periodic payment amount of annuity</param>
    /// <param name="ratePerPeriod">Rate per period</param>
    /// <param name="numberOfPeriods">Number of periods</param>
    /// <param name="round">Determines whether the result is rounded to 2 decimal places</param>
    /// <returns>Future value of annuity</returns>
/*    public static decimal FutureValueOfAnnuity(decimal periodicPayment, decimal ratePerPeriod, int numberOfPeriods, bool round = true)
    {
        var futureValueOfAnnuity = periodicPayment * ((DecimalPower((1 + ratePerPeriod / 100), numberOfPeriods) - 1) / (ratePerPeriod / 100));

        return round ? Math.Round(futureValueOfAnnuity, 2) : futureValueOfAnnuity;
    }

    /// <summary>
    /// Returns the annuity payment calculated for a present value given the rate and number of periods
    /// </summary>
    /// <param name="presentValue">Present value of annuity</param>
    /// <param name="ratePerPeriod">Rate per peroid (6 = 6%)</param>
    /// <param name="numberOfPeriods">Number of periods</param>
    /// <param name="round">Determines whether the result is rounded to 2 decimal places</param>
    /// <returns></returns>
    public static decimal AnnuityPaymentPresentValue(decimal presentValue, decimal ratePerPeriod, int numberOfPeriods, bool round = true)
    {
        var annuityPayment = (presentValue * ratePerPeriod / 100) / (1 - DecimalPower(1 + ratePerPeriod / 100, numberOfPeriods * -1));

        return round ? Math.Round(annuityPayment, 2) : annuityPayment;
    }*/

    /// <summary>
    /// Returns the annuity payment calculated for a future value given the rate and number of periods
    /// </summary>
    /// <param name="futureValue">Future value of annuity</param>
    /// <param name="ratePerPeriod">Rate per peroid (6 = 6%)</param>
    /// <param name="numberOfPeriods">Number of periods</param>
    /// <param name="round">Determines whether the result is rounded to 2 decimal places</param>
    /// <returns></returns>
/*    public static decimal AnnuityPaymentFutureValue(decimal futureValue, decimal ratePerPeriod, int numberOfPeriods, bool round = true)
    {
        var annuityPayment = (futureValue * ratePerPeriod / 100) / (DecimalPower(1 + ratePerPeriod / 100, numberOfPeriods) - 1);

        return round ? Math.Round(annuityPayment, 2) : annuityPayment;
    }

    /// <summary>
    /// Returns the remaining balance of an annuity given the original value, payment amount, rate per period and number of periods paid
    /// </summary>
    /// <param name="originalValue">Originial annuity value</param>
    /// <param name="payment">Payment amount</param>
    /// <param name="ratePerPeriod">Rate per peroid (6 = 6%)</param>
    /// <param name="numberOfPeriods">Number of periods</param>
    /// <param name="round">Determines whether the result is rounded to 2 decimal places</param>
    /// <returns>Remaining balance of an annuity</returns>
    public static double RemainingBalanceOfAnnuity(decimal originalValue, decimal payment, decimal ratePerPeriod, int numberOfPeriods, bool round = true)
    {
        var remaining = FutureValue(originalValue, ratePerPeriod, numberOfPeriods, false) - FutureValueOfAnnuity(payment, ratePerPeriod, numberOfPeriods, false);

        return round ? Math.Round(remaining, 2) : remaining;
    }*/

    /**
     * Calculates the value of a decimal raised to an integer value
     * @param value Value to raise to a power.
     * @param power Exponent for calculation
     * @return Resulting value raised to power.
     */
    private static BigDecimal decimalPower(BigDecimal value, int power)
    {
        if (power == 0)
            return new BigDecimal(1);

        boolean negativePower = false;
        BigDecimal result = value;

        if (power < 0)
        {
            negativePower = true;
            power *= -1;
        }
        
        while (power > 1)
        {
            result = result.add(result.multiply(value));
            power--;
        }

        return negativePower ? new BigDecimal(1).divide(result, BigDecimal.ROUND_UNNECESSARY) : result;
    }
}

