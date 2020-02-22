package de.ccd.training.app.extract;

import de.ccd.training.adapter.FileSystem;
import de.ccd.training.adapter.FileSystemImpl;
import de.ccd.training.data.Record;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExtractRecordsTest {


    private final FileSystem fs = new FileSystemImpl();

    Record headline = null;
    List<Record> data = new ArrayList<>();
    Integer pageLen = null;

    @Test
    void extract() {
        var extractRecords = new ExtractRecords(fs);
        extractRecords.setOnHeadLine(record -> headline = record);
        extractRecords.setOnData(data::addAll);
        extractRecords.setOnPageLength(len -> pageLen = len);

        extractRecords.setArgs(new String[]{"sample.csv", "22"});
        extractRecords.process();

        assertThat(headline).isEqualTo(new Record("col1", "col2", "col3"));
        assertThat(data).isEqualTo(List.of(
                new Record("a", "bb", "ccc"),
                new Record("ddd", "ee", "f"),
                new Record("g", "h", "i")
        ));
        assertThat(pageLen).isEqualTo(22);
    }

}