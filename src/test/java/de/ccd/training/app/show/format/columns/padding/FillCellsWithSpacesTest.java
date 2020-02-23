package de.ccd.training.app.show.format.columns.padding;

import de.ccd.training.data.Column;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FillCellsWithSpacesTest {

    Column paddedColumn = null;

    @Test
    void fillCells() {
        var fillCellWithSpaces = new FillCellsWithSpaces(new Column("a", "aa", "aaa"));
        fillCellWithSpaces.setOnColumnPadded(col -> paddedColumn = col);
        fillCellWithSpaces.setCellStringLength("aaa".length());

        fillCellWithSpaces.process();

        assertThat(paddedColumn).isEqualTo(new Column(List.of(
                "a  ",
                "aa ",
                "aaa"
        )));

    }

}