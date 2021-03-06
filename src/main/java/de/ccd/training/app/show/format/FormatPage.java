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
        var assembleColumns = new AssembleColumns(header, page);
        var assemblePage = new AssemblePage();

        assembleColumns.setOnAssembledColumns(assemblePage::setColumns);
        assemblePage.setOnAssembledPage(onFormattedPage);

        assembleColumns.process();
        assemblePage.process();
    }

}
