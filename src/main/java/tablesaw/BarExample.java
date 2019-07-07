package tablesaw;
import tech.tablesaw.api.*;
import tech.tablesaw.columns.numbers.IntColumnType;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.HorizontalBarPlot;
import tech.tablesaw.plotly.api.VerticalBarPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.components.Marker;
import tech.tablesaw.plotly.traces.BarTrace;
import tech.tablesaw.plotly.traces.Trace;

import static tech.tablesaw.aggregate.AggregateFunctions.sum;

/**
 * Basic sample vertical bar chart
 */
public class BarExample {

    public static void main(String[] args) throws Exception {
        String[] animals = {"bear", "cat", "giraffe"};
        double[] cuteness = {90.1, 84.3, 99.7};
        int[] injuries = {90, 84, 9};

        Table table = Table.create("Cute Animals")
                .addColumns(
                        StringColumn.create("Animal types", animals),
                        DoubleColumn.create("rating", cuteness),
                        IntColumn.create("scale", injuries));
        System.out.println(table.printAll());


        IntColumn scale = table.intColumn("scale");
        scale.set(scale.isLessThan(0), IntColumnType.missingValueIndicator());

        Table summaryTable = table.summarize("fatalities", "log injuries", sum).by("Scale");

        Plot.show(HorizontalBarPlot.create("Tornado Impact", summaryTable, "scale", Layout.BarMode.STACK,"Sum [Fatalities]", "Sum [log injuries]"));

        Plot.show(
                VerticalBarPlot.create("Tornado Impact", summaryTable, "scale", Layout.BarMode.GROUP,"Sum [Fatalities]", "Sum [log injuries]"));


        Layout layout = Layout.builder()
                .title("Tornado Impact")
                .barMode(Layout.BarMode.GROUP)
                .showLegend(true)
                .build();

        String[] numberColNames = {"Sum [Fatalities]", "Sum [log injuries]"};
        String[] colors = {"#85144b", "#FF4136"};

        Trace[] traces = new Trace[2];
        for (int i = 0; i < 2; i++) {
            String name = numberColNames[i];
            BarTrace trace = BarTrace.builder(
                    summaryTable.categoricalColumn("scale"),
                    summaryTable.numberColumn(name))
                    .orientation(BarTrace.Orientation.VERTICAL)
                    .marker(Marker.builder().color(colors[i]).build())
                    .showLegend(true)
                    .name(name)
                    .build();
            traces[i] = trace;
        }
        Plot.show(new Figure(layout, traces));
    }
}