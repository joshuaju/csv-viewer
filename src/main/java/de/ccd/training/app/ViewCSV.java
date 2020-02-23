package de.ccd.training.app;

import de.ccd.training.adapter.*;
import de.ccd.training.app.extract.ExtractRecords;
import de.ccd.training.app.paginate.Paginate;
import de.ccd.training.app.show.ShowPage;

public class ViewCSV {

    private String[] args;

    public ViewCSV(String[] args) {
        this.args = args;
    }

    public void process() {
        Console console = new ConsoleImpl();
        FileSystem fileSystem = new FileSystemImpl();
        PageStore pageStore = new PageStoreImpl();

        var extractRecords = new ExtractRecords(fileSystem);
        var paginate = new Paginate();
        var showPage = new ShowPage(console, pageStore);

        extractRecords.setOnHeadLine(showPage::setHeader);
        extractRecords.setOnData(paginate::setData);
        extractRecords.setOnPageLength(paginate::setPageLength);
        extractRecords.setArgs(args);
        paginate.setOnPaginatedPages(pageStore::store); // Paginate does not need the PageStore anymore

        extractRecords.process();
        paginate.process();
        showPage.process();
    }

}
