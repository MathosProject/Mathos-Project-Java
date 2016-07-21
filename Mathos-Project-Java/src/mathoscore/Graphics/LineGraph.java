package mathoscore.graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A simple line graph for displaying either an array or list of numbers.
 *
 * @author Ethan Dagner (napen123@gmail.com), Mathos Project
 */
public class LineGraph extends Graph {
    public List<Double> data;

    public int pointWidth = 4;
    public int defaultPadding = 25;
    public int labelPadding = 25;
    public int numberYDivisions = 10;

    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);

    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);

    public LineGraph(int width, int height, List<Double> data) {
        super(width, height);

        this.data = data;
    }

    public LineGraph(int width, int height, Double[] data) {
        this(width, height, Arrays.asList(data));
    }

    public LineGraph(int width, int height, double[] data) {
        super(width, height);

        List<Double> realData = new ArrayList<>();

        for(double item : data) {
            realData.add(item);
        }

        this.data = realData;
    }

    public double max() {
        return Collections.max(data);
    }

    public double min() {
        return Collections.min(data);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D)graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double)getWidth() - (2 * defaultPadding) - labelPadding) / (data.size() - 1);
        double yScale = ((double)getHeight() - 2 * defaultPadding - labelPadding) / (max() - min());

        List<Point> graphPoints = new ArrayList<>();

        for(int i = 0; i < data.size(); i++) {
            int x = (int)(i * xScale + defaultPadding + labelPadding);
            int y = (int)((max() - data.get(i)) * yScale + defaultPadding);

            graphPoints.add(new Point(x, y));
        }

        g.setColor(Color.white);
        g.fillRect(defaultPadding + labelPadding, defaultPadding, getWidth() - (2 * defaultPadding) - labelPadding, getHeight() - 2 * defaultPadding - labelPadding);
        g.setColor(Color.black);

        FontMetrics metrics = g.getFontMetrics();

        for(int i = 0; i < numberYDivisions; i++) {
            int x1 = defaultPadding + labelPadding;
            int x2 = pointWidth + defaultPadding + labelPadding;
            int y = getHeight() - ((i * (getHeight() - defaultPadding * 2 - labelPadding)) / numberYDivisions + defaultPadding + labelPadding);

            if(data.size() > 0) {
                g.setColor(gridColor);
                g.drawLine(defaultPadding + labelPadding + 1 + pointWidth, y, getWidth() - defaultPadding, y);
                g.setColor(Color.black);

                String yLabel = ((int)((min() + (max() - min()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                int labelWidth = metrics.stringWidth(yLabel);

                g.drawString(yLabel, x1 - labelWidth - 5, y + (metrics.getHeight() / 2) - 3);
            }

            g.drawLine(x1, y, x2, y);
        }

        for(int i = 0; i < data.size(); i++) {
            if(data.size() > 1) {
                int x = i * (getWidth() - defaultPadding * 2 - labelPadding) / (data.size() - 1) + defaultPadding + labelPadding;
                int y1 = getHeight() - defaultPadding - labelPadding;
                int y2 = y1 - pointWidth;

                if ((i % ((int) ((data.size() / 20.0)) + 1)) == 0) {
                    g.setColor(gridColor);
                    g.drawLine(x, getHeight() - defaultPadding - labelPadding - 1 - pointWidth, x, defaultPadding);
                    g.setColor(Color.black);

                    String xLabel = i + "";
                    int labelWidth = metrics.stringWidth(xLabel);

                    g.drawString(xLabel, x - labelWidth / 2, y1 + metrics.getHeight() + 3);
                }

                g.drawLine(x, y1, x, y2);
            }
        }

        g.drawLine(defaultPadding + labelPadding, getHeight() - defaultPadding - labelPadding, defaultPadding + labelPadding, defaultPadding);
        g.drawLine(defaultPadding + labelPadding, getHeight() - defaultPadding - labelPadding, getWidth() - defaultPadding, getHeight() - defaultPadding - labelPadding);

        Stroke oldStroke = g.getStroke();
        g.setColor(lineColor);
        g.setStroke(GRAPH_STROKE);

        for(int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;

            g.drawLine(x1, y1, x2, y2);
        }

        g.setStroke(oldStroke);
        g.setColor(pointColor);

        for (Point graphPoint : graphPoints) {
            int x = graphPoint.x - pointWidth / 2;
            int y = graphPoint.y - pointWidth / 2;

            g.fillOval(x, y, pointWidth, pointWidth);
        }
    }
}
