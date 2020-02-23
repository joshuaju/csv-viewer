package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class InsertUnderline {

    @Setter
    private List<Column> columns;

    @Setter
    private Consumer<List<Column>> onUnderlinedColumns;

    public void process() {
        var underlinedColumns = columns.stream().map(this::underline).collect(Collectors.toList());
        onUnderlinedColumns.accept(underlinedColumns);
    }

    private Column underline(Column col) {
        ArrayList<String> cells = new ArrayList<>(List.copyOf(col.getCells()));
        var requiredDashesForUnderline = cells.get(0).length();
        cells.add(1, "-".repeat(requiredDashesForUnderline));
        return new Column(cells);

    }

}
