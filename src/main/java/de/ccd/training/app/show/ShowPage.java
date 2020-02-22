package de.ccd.training.app.show;

import de.ccd.training.adapter.Console;
import de.ccd.training.adapter.PageStore;
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
    }
}
