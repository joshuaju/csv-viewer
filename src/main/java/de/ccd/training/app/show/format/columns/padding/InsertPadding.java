package de.ccd.training.app.show.format.columns.padding;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class InsertPadding {

    @Setter
    private List<Column> columns = List.of();

    @Setter
    private Consumer<List<Column>> onPaddedColumns;

    private List<Column> paddedColumns = new ArrayList<>();

    public void process() {
        System.out.println("insert padding");
        columns.forEach(this::processEach);
        onPaddedColumns.accept(paddedColumns);
    }

    private void processEach(Column column) {
        var determineMax = new DetermineMax(column);
        var fillCellsWithSpaces = new FillCellsWithSpaces(column);

        determineMax.setOnMaxColumnWidth(fillCellsWithSpaces::setCellStringLength);
        fillCellsWithSpaces.setOnColumnPadded(paddedColumns::add);

        determineMax.process();
        fillCellsWithSpaces.process();
    }

}
