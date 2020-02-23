package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

class InsertSeparatorColumns {

    @Setter
    private Consumer<List<Column>> onSeparatedColumns;

    @Setter
    private List<Column> columns;

    public void process() {
        var separator = createSeparatorColum(columns);
        ArrayList<Column> separatedColumns = new ArrayList<>();
        var columnIterator = columns.iterator();
        while (columnIterator.hasNext()) {
            var column = columnIterator.next();
            separatedColumns.add(new Column(List.copyOf(column.getCells())));
            if (columnIterator.hasNext()) separatedColumns.add(separator);
        }
        onSeparatedColumns.accept(separatedColumns);
    }

    private Column createSeparatorColum(List<Column> colums) {
        var sampleColumn = columns.get(0);
        List<String> cells = new ArrayList<>();
        cells.add("|");
        cells.add("+");
        int bound = sampleColumn.getCells().size() - 2;
        for (int i = 0; i < bound; i++) {
            cells.add("|");
        }
        return new Column(cells);
    }


}
