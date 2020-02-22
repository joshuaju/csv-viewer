package de.ccd.training.app.show.format;

import de.ccd.training.app.show.format.columns.AssembleColumns;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class FormatPage {

    private final Record header;

    @Setter
    private Consumer<String> onFormattedPage;

    @Setter
    private Page page;

    public void process() {
        System.out.println("format page");

        var assembleColumns = new AssembleColumns(header, page);
        var insertSeparatorColumns = new InsertSeparatorColumns(); // push down to "assemble columns"?
        var assemblePage = new AssemblePage();

        assembleColumns.setOnAssembledColumns(insertSeparatorColumns::setColumns);
        insertSeparatorColumns.setOnSeparatedColumns(assemblePage::setColumns);

        assembleColumns.process();
        insertSeparatorColumns.process();
        assemblePage.process();
    }

}
