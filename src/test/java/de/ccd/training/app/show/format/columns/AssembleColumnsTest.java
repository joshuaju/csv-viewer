package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.SheetCollate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AssembleColumnsTest {

    @Test
    void assemble() {
        Record header = new Record("col1", "col2", "column 3");
        Page data = new Page(List.of(
                new Column("a", "aa", "aaaa"),
                new Column("b", "bbbbb", "bb"),
                new Column("c", "cc", "ccc")
        ));

        var assembleColumns = new AssembleColumns(header, data);
        var assembledColumns = new ArrayList<>();
        assembleColumns.setOnAssembledColumns(assembledColumns::addAll);

        assembleColumns.process();

        assertThat(assembledColumns).isEqualTo(List.of(
                new Column("col1", "----", "a   ", "aa  ", "aaaa"),
                new Column("|", "+", "|", "|", "|"),
                new Column("col2 ", "-----", "b    ", "bbbbb", "bb   "),
                new Column("|", "+", "|", "|", "|"),
                new Column("column 3", "--------", "c       ", "cc      ", "ccc     ")
        ));
    }

}