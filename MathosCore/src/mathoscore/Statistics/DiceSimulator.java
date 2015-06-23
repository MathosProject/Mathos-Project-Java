package mathoscore.statistics;

import java.util.Date;
import java.util.Random;

public class DiceSimulator {
    private final int _numDice;
    private final int[] _nRolledValue;
    private final Random _rnd;

    public DiceSimulator(int nDice) {
        _numDice = nDice;
        _nRolledValue = new int[_numDice];

        int _seed = ((int) new Date().getTime());

        _rnd = new Random(_seed);

        for(int i = 0; i < _numDice; i++) {
            roll(i);
        }
    }

    public int roll(int nDiceIndex) {
        int nResult = _rnd.nextInt() % 6;

        _nRolledValue[nDiceIndex] = nResult + 1;

        return _nRolledValue[nDiceIndex];
    }

    public int sumDiceRoll() {
        int nSum = 0;

        for(int i = 0; i < _numDice; i++) {
            nSum += _nRolledValue[i];
        }

        return nSum;
    }

    public int maxDiceRoll() {
        int nMax = 0;

        for(int i = 0; i < _numDice; i++) {
            nMax = Math.max(nMax, _nRolledValue[i]);
        }

        return nMax;
    }

    public int diffDiceRoll() {
        int nSub = 0;

        for(int i = 0; i < _numDice; i++) {
            nSub = Math.abs(nSub - _nRolledValue[i]);
        }

        return nSub;
    }

    public int get(int i) {
        try {
            return _nRolledValue[i];
        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public String toString() {
        String dceInfo = "";

        for(int i = 0; i < _numDice; i++) {
            dceInfo += " Dice " + i + " : " + _nRolledValue[i];
        }

        return dceInfo;
    }
}
