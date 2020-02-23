package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConvertToColumnsTest {

    @Test
    void convertToColumns() {
        var convertToColumns = new ConvertToColumns(
                new Record("col1", "col2"),
                new Page(List.of(
                        new Column("a", "aa"),
                        new Column("b", "bb")
                )));

        var convertedColumns = new ArrayList<>();
        convertToColumns.setOnConverted(convertedColumns::addAll);

        convertToColumns.process();

        assertThat(convertedColumns).isEqualTo(List.of(
                new Column("col1", "a", "aa"),
                new Column("col2", "b", "bb")
        ));
    }

}