import javax.swing.*;
import java.awt.*;

/**
 * The Plot https://coderanch.com/t/323434/java/plot-graph-Java
 */
class Plot extends JPanel {
    double[] x ;
    double[] y ;
    int size;
    int[] xx;
    int[] yy;
    String xlabel, ylabel, title;
    int xdim, ydim, yzero, xzero, xdraw, ydraw;
    int xtic, ytic;
    int  xpoint, ypoint;
    double xmax, xmin, ymax, ymin;
    int right=0;
    public Plot(int size,Individual [] individuals) {
        this.size = size;
        y = new double[size];
        x = new double[size];

        xx = new int[size];
         yy = new int[size];
        for (int i = 0; i<size;i++){

            y[i] = individuals[i].fitness;
            x[i] = i;
        }
         xdim = 300;
        ydim = 300;
        xtic = 10;
        ytic = 10;
        xlabel = ("Individuals");
        ylabel = ("Fitness");
        title = ylabel + " versus " + xlabel;

        xmax = x[0];
        xmin = x[0];
        ymax = y[0];
        ymin = y[0];

        for (int i = 0; i < size; i++) {
            if (x[i] > xmax) {
                xmax = x[i];
            }
            if (x[i] < xmin) {
                xmin = x[i];
            }
            if (y[i] > ymax) {
                ymax = y[i];
            }
            if (y[i] < ymin) {
                ymin = y[i];
            }

        }
        //xx and yy are the scaled x and y used for plotting

        for (int i = 0; i < size; i++) {
            xx[i] = (int) (right+50 + (((x[i] - xmin) / (xmax - xmin)) * (xdim - 100)));
            yy[i] = (int) ((ydim - 50) - (((y[i] - ymin) / (ymax - ymin)) * (ydim - 100)));
        }
//Find Zero point on y-axis required for drawing the axes
        if ((ymax * ymin) < 0) {
            yzero = (int) ((ydim - 50) - (((0 - ymin) / (ymax - ymin)) * (ydim - 100)));
        } else {
            yzero = (int) ((ydim - 50) - ((0 / (ymax - ymin)) * (ydim - 100)));
        }
//Find zero point on x-axis required for drawing the axes
        if ((xmax * xmin) < 0) {
            xzero = (int) (right +50+ (((0 - xmin) / (xmax - xmin)) * (xdim - 100)));
        } else {
            xzero = (int) (right + 50+((0 / (xmax - xmin)) * (xdim - 100)));
        }
//Now ready to plot the results
        repaint();
    }

    public void paint(Graphics g) {

        Font f1 = new Font("TimesRoman", Font.PLAIN, 10);
        g.setFont(f1);

        g.drawLine(xzero, 50, xzero, ydim - 50);
        g.drawLine(xzero, 50, (xzero - 5), 55);
        g.drawLine(xzero, 50, (xzero + 5), 55);

        g.drawLine(right+50, yzero,right+ xdim , yzero);
        g.drawLine(right+50, yzero, (right+xdim ), (yzero));
        g.drawLine(right+50, yzero, (right+xdim ), (yzero));


        if (xmin <= 0) {
            xpoint = (int) (xmin - (xmin % xtic));
        } else {
            xpoint = (int) (xmin - (xmin % xtic) + xtic);
        }
        do {
            xdraw = (int) (right + 50 + (((xpoint - xmin) / (xmax - xmin)) * (xdim - 100)));
            g.drawString(xpoint + "", xdraw, (yzero + 10));
            xpoint = xpoint + xtic;
        } while (xpoint <= xmax);

        if (ymin <= 0) {
            ypoint = (int) (ymin - (ymin % ytic));
        } else {
            ypoint = (int) (ymin - (ymin % ytic) + ytic);
        }
        do {
            ydraw = (int) ((ydim - 50) - (((ypoint - ymin) / (ymax - ymin)) * (ydim - 100)));
            g.drawString(ypoint + "", (xzero - 20), ydraw);
            ypoint = ypoint + ytic;
        } while (ypoint <= ymax);

        Font f2 = new Font("TimesRoman", Font.BOLD, 14);
        g.setFont(f2);
        g.drawString(xlabel, (right+xdim - 100), (yzero + 25));
        g.drawString(ylabel, (xzero - 25), 40);
        g.drawString(title, (right+xdim / 2 - 75), 20);

        for (int j = 0; j < size - 1; j++) {
            g.drawLine(xx[j], yy[j], xx[j + 1], yy[j + 1]);
        }
    }
}