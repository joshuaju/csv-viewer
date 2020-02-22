package de.ccd.training.app.extract;

import de.ccd.training.data.Record;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitIntoHeadlineAndDataTest {

    private Record headline = null;
    private List<Record> data = new ArrayList<>();

    @Test
    void split(){
        var split = new SplitIntoHeadlineAndData();

        split.setOnHeadline(record -> headline = record);
        split.setOnData(data::addAll);

        split.setRecords(List.of(
                new Record("col1", "col2"),
                new Record("a", "b"),
                new Record("c", "d")
        ));

        split.process();

        assertThat(headline).isEqualTo(new Record("col1", "col2"));
        assertThat(data).isEqualTo(List.of(new Record("a", "b"), new Record("c", "d")));
    }

}