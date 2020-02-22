package de.ccd.training.app.show.format.columns.padding;

import de.ccd.training.data.Column;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
class FillCellsWithSpaces {

    private final Column column;

    @Setter
    private Consumer<Column> onColumnPadded;

    @Setter
    private Integer cellStringLength;

    public void process() {
        System.out.println("fill cells with spaces");
    }
}
