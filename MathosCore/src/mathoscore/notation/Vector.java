package mathoscore.notation;

import java.util.ArrayList;

public class Vector {
    private ArrayList<Double> _vectorContent;

    public Vector() {
        this(new double[0]);
    }

    public Vector(double... vectors) {
        _vectorContent = new ArrayList<>();

        for(double vector : vectors)
            _vectorContent.add(vector);
    }

    public void Add(double number) {
        _vectorContent.add(number);
    }

    public int getLength() {
    	return _vectorContent.size();
    }
}
