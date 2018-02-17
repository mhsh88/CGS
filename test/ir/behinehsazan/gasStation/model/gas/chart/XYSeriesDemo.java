package ir.behinehsazan.gasStation.model.gas.chart;

import ir.behinehsazan.gasStation.model.gas.BaseGas;
import ir.behinehsazan.gasStation.model.gas.Gas;
import ir.behinehsazan.gasStation.model.mathCalculation.MathCalculation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class XYSeriesDemo extends ApplicationFrame {

    /**
     * A demonstration application showing an XY series containing a null value.
     *
     * @param title  the frame title.
     */
    public XYSeriesDemo(final String title) {

        super(title);
        final XYSeries series = new XYSeries("Random Data");
//        Double[] component = {0.057, 0.076, 0.812, 0.043, 0.009, 0.0015, 0.0015, 0., 0., 0.
//                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
//                , 0.};
        Double[] component = {0.1, 0.1, 11., 0.1, 0.1, 0.0015, 0.0015, 0.1, 0.1, 0.1
                , 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
                , 0.};
        double sum = MathCalculation.listSum(component);
        for (int i = 0; i < component.length; i++) {
            component[i] = component[i] / sum;
        }

        BaseGas gas = new Gas();
        for(int j = 0; j<250; j++) {

            Double P = j * 6.89476 + 101.235;
            Double T = 273.15 + 8;



            gas.calculate(P, T, component);
            series.add(j, gas.getT_h());
            System.out.println(j + "   " + Math.round(P - 101.235) +  "   " + gas.getT_h());
        }




//        series.add(1.0, 500.2);
//        series.add(5.0, 694.1);
//        series.add(4.0, 100.0);
//        series.add(12.5, 734.4);
//        series.add(17.3, 453.2);
//        series.add(21.2, 500.2);
//        series.add(21.9, null);
//        series.add(25.6, 734.4);
//        series.add(30.0, 453.2);
        final XYSeriesCollection data = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "XY Series Demo",
                "X",
                "Y",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

// ****************************************************************************
// * JFREECHART DEVELOPER GUIDE                                               *
// * The JFreeChart Developer Guide, written by David Gilbert, is available   *
// * to purchase from Object Refinery Limited:                                *
// *                                                                          *
// * http://www.object-refinery.com/jfreechart/guide.html                     *
// *                                                                          *
// * Sales are used to provide funding for the JFreeChart project - please    *
// * support us so that we can continue developing free software.             *
// ****************************************************************************

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final XYSeriesDemo demo = new XYSeriesDemo("XY Series Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
