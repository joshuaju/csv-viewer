package de.ccd.training.app.extract;

import de.ccd.training.data.Record;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParseRecordsTest {

    private Record headline = null;
    private List<Record> data = new ArrayList<>();

    @Test
    void parse() {
        var parseRecords = new ParseRecords();
        parseRecords.setOnHeadLine(record -> headline = record);
        parseRecords.setOnData(data::addAll);

        parseRecords.setLines(List.of(
                "col1;col2;col3",
                "a;bb;ccc",
                "ddd;ee;f"
        ));

        parseRecords.process();
        assertThat(headline).isEqualTo(new Record("col1", "col2", "col3"));
        assertThat(data).isEqualTo(List.of(
                new Record("a", "bb", "ccc"),
                new Record("ddd", "ee", "f")
        ));
    }

}