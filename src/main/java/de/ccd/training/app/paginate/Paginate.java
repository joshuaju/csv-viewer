package de.ccd.training.app.paginate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Record;
import lombok.Setter;

import java.util.List;

public class Paginate {

    @Setter
    private List<Record> data;
    @Setter
    private Integer pageLength;

    private PageStore pageStore;

    public Paginate(PageStore pageStore) {
        this.pageStore = pageStore;
    }

    public void process() {
        System.out.println("paginate");
    }
}
