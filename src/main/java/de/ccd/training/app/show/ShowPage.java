package de.ccd.training.app.show;

import de.ccd.training.adapter.Console;
import de.ccd.training.adapter.PageStore;
import de.ccd.training.app.show.evaluate.*;
import de.ccd.training.app.show.format.FormatPage;
import de.ccd.training.app.show.interact.Interact;
import de.ccd.training.data.Record;
import lombok.Setter;

public class ShowPage {

    @Setter
    private Record header;

    private Console console;
    private PageStore pageStore;

    public ShowPage(Console console, PageStore pageStore) {
        this.console = console;
        this.pageStore = pageStore;
    }

    public void process() {
        System.out.println("show page");

        var exitCSVViewer = new ExitCSVViewer();
        var selectFirstPage = new SelectFirstPage(pageStore);
        var selectNextPage = new SelectNextPage(pageStore);
        var selectPreviousPage = new SelectPreviousPage(pageStore);
        var selectLastPage = new SelectLastPage(pageStore);

        var formatPage = new FormatPage(header);
        var interact = new Interact(console);
        var evaluateKey = new EvaluateKey();

        selectFirstPage.setOnPageSelected(formatPage::setPage);
        selectNextPage.setOnPageSelected(formatPage::setPage);
        selectPreviousPage.setOnPageSelected(formatPage::setPage);
        selectLastPage.setOnPageSelected(formatPage::setPage);
        evaluateKey.setOnExit(exitCSVViewer::process);
        evaluateKey.setOnFirstPage(selectFirstPage::process);
        evaluateKey.setOnNextPage(selectNextPage::process);
        evaluateKey.setOnPreviousPage(selectPreviousPage::process);
        evaluateKey.setOnLastPage(selectLastPage::process);
        formatPage.setOnFormattedPage(interact::setFormattedPage);
        interact.setOnUserInput(evaluateKey::setKey);

        selectFirstPage.process();
        formatPage.process();
        interact.process();
        evaluateKey.process();
        formatPage.process();
        interact.process();
    }
}
