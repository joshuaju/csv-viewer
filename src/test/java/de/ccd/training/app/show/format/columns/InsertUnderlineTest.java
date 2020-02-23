package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InsertUnderlineTest {

    @Test
    void underline() {
        var insertUnderline = new InsertUnderline();
        insertUnderline.setColumns(List.of(
                new Column("aaa", "aa"),
                new Column("bbbbbb", "b")
        ));

        List<Column> underlinedColumns = new ArrayList<>();
        insertUnderline.setOnUnderlinedColumns(underlinedColumns::addAll);

        insertUnderline.process();

        assertThat(underlinedColumns).isEqualTo(List.of(
                new Column("aaa", "---", "aa"),
                new Column("bbbbbb", "------", "b")
        ));
    }

}