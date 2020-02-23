package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
class ConvertToColumns {

    private final Record header;
    private final Page page;

    @Setter
    private Consumer<List<Column>> onConverted;

    public void process() {
        System.out.println("convert to columns");
        var headerValues = header.getValues();
        var columns = page.getColumns();

        assert headerValues.size() == columns.size();
        List<Column> columnsWithHeader = IntStream.range(0, headerValues.size())
                .mapToObj(index -> {
                    var head = headerValues.get(index);
                    var col = columns.get(index);
                    return addHeader(head, col);
                }).collect(Collectors.toList());

        onConverted.accept(columnsWithHeader);
    }

    private Column addHeader(String head, Column col) {
        List<String> values = new ArrayList<>();
        values.add(head);
        values.addAll(List.copyOf(col.getCells()));
        return new Column(values);
    }


}
