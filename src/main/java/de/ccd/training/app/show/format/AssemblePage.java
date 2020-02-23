package de.ccd.training.app.show.format;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

class AssemblePage {

    @Setter
    private Consumer<String> onAssembledPage;

    @Setter
    private List<Column> columns;

    public void process() {
        int numberOfRows = rowCount(columns);

        StringBuilder pageBuilder = new StringBuilder();
        for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
            int finalCurrentRow = currentRow;
            columns.stream()
                    .map(column -> column.getCells().get(finalCurrentRow))
                    .forEach(pageBuilder::append);
            pageBuilder.append("\n");
        }
        onAssembledPage.accept(pageBuilder.toString());
    }

    private int rowCount(List<Column> columns) {
        var sampleColumn = columns.get(0);
        return sampleColumn.getCells().size();
    }

}
