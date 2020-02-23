package de.ccd.training.app.paginate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Paginate {

    @Setter
    private List<Record> data;
    @Setter
    private Integer pageLength;

    @Setter
    private Consumer<List<Page>> onPaginatedPages;

    public void process() {
        var recordsPerPage = separateRecordsByPagelen(data, pageLength);

        var pages = recordsPerPage.stream()
                .map(this::convertRecordsToColumns)
                .map(Page::new)
                .collect(Collectors.toList());

        onPaginatedPages.accept(pages);
    }

    private List<List<Record>> separateRecordsByPagelen(List<Record> records, int pageLength) {
        List<List<Record>> recordsPerPage = new ArrayList<>();
        int startOfPage = 0;
        while (startOfPage < records.size()) {
            int endOfPage = Math.min(startOfPage + pageLength, records.size());
            var pageRecords = records.subList(startOfPage, endOfPage);
            recordsPerPage.add(List.copyOf(pageRecords));
            startOfPage = endOfPage;
        }
        return recordsPerPage;
    }

    private List<Column> convertRecordsToColumns(List<Record> records) {
        List<Column> columns = new ArrayList<>();
        int numberOfColumns = columnCount(data);
        for (int currentColumn = 0; currentColumn < numberOfColumns; currentColumn++) {
            int finalCurrentColumn = currentColumn;
            var cells = records.stream()
                    .map(record -> record.getValues().get(finalCurrentColumn))
                    .collect(Collectors.toList());
            var column = new Column(cells);
            columns.add(column);
        }
        return columns;
    }

    private int columnCount(List<Record> records) {
        var sample = records.get(0);
        return sample.getValues().size();
    }
}
