package de.ccd.training.app.show.format.columns;

import de.ccd.training.app.show.format.columns.padding.InsertPadding;
import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class AssembleColumns {

    private final Record header;
    private final Page page;

    @Setter
    private Consumer<List<Column>> onAssembledColumns;

    public void process() {
        var convertToColumns = new ConvertToColumns(header, page);
        var insertPadding = new InsertPadding();
        var insertUnderline = new InsertUnderline();
        var insertSeparatorColumns = new InsertSeparatorColumns();

        convertToColumns.setOnConverted(insertPadding::setColumns);
        insertPadding.setOnPaddedColumns(insertUnderline::setColumns);
        insertUnderline.setOnUnderlinedColumns(insertSeparatorColumns::setColumns);
        insertSeparatorColumns.setOnSeparatedColumns(onAssembledColumns);

        convertToColumns.process();
        insertPadding.process();
        insertUnderline.process();
        insertSeparatorColumns.process(); // pulled down from format page (see flow diagram)
    }

}
