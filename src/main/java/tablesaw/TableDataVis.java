package tablesaw;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

public class TableDataVis {
    public static void main(String[] args) {
        String[] animals = {"bear", "cat", "giraffe"};
        double[] cuteness = {90.1, 84.3, 99.7};

        Table cuteAnimals = Table.create("Cute Animals")
                .addColumns(
                        StringColumn.create("Animal types", animals),
                        DoubleColumn.create("rating", cuteness));
        System.out.println(cuteAnimals.printAll());
    }
}
