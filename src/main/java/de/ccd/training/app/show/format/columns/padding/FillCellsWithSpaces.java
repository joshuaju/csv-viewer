package de.ccd.training.app.show.format.columns.padding;

import de.ccd.training.data.Column;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class FillCellsWithSpaces {

    private final Column column;

    @Setter
    private Consumer<Column> onColumnPadded;

    @Setter
    private Integer cellStringLength;

    public void process() {
        System.out.println("fill cells with spaces");
        List<String> values = column.getCells().stream()
                .map(this::fillWithSpaces)
                .collect(Collectors.toList());
        var paddedColumn = new Column(values);
        onColumnPadded.accept(paddedColumn);
    }

    private String fillWithSpaces(String value) {
        int requiredSpaces = cellStringLength - value.length();
        String spaces = " ".repeat(requiredSpaces);
        return String.format("%s%s", value, spaces);
    }
}
