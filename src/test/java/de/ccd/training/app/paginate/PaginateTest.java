package de.ccd.training.app.paginate;

import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PaginateTest {

    List<Page> pages = new ArrayList<>();

    @Test
    void paginate() {
        var paginate = new Paginate();
        paginate.setOnPaginatedPages(pages::addAll);
        paginate.setData(List.of(
                new Record("A1", "A", "A"),
                new Record("A2", "AA", "AA"),
                new Record("A3", "AAA", "AAA"),
                new Record("B2", "BB", "BB")
        ));
        paginate.setPageLength(3);

        paginate.process();

        assertThat(pages).isEqualTo(List.of(
                new Page(List.of(
                        new Column("A1", "A2", "A3"),
                        new Column("A", "AA", "AAA"),
                        new Column("A", "AA", "AAA")
                )),
                new Page(List.of(
                        new Column("B2"),
                        new Column("BB"),
                        new Column("BB")
                ))));
    }

}