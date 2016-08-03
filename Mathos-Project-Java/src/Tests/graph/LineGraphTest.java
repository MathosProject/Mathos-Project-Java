package tests.graph;

import mathos.graphics.Graph;
import mathos.graphics.LineGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGraphTest {

    public static void main(String[] args) {
        Random random = new Random();
        List<Double> data = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            data.add(random.nextDouble() * 10);
        }

        Graph.graph(new LineGraph(640, 480, data));
    }
}
