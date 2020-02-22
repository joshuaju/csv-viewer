package de.ccd.training.app.extract;

import de.ccd.training.data.Record;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConvertLinesToRecordsTest {

    private List<Record> result = new ArrayList<>();

    @Test
    void splitLine(){
        var convertLinesToRecords = new ConvertLinesToRecords(List.of(
                "a;b;c;d",
                "1;2;3;4"
        ));
        convertLinesToRecords.setOnRecords(result::addAll);

        convertLinesToRecords.process();

        assertThat(result).isEqualTo(List.of(
                new Record("a", "b", "c", "d"), new Record("1", "2", "3", "4")
        ));
    }

}