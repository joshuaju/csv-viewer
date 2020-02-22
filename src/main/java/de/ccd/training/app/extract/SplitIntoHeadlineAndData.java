package de.ccd.training.app.extract;

import de.ccd.training.data.Record;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

class SplitIntoHeadlineAndData {

    @Setter
    private List<Record> records;

    @Setter
    private Consumer<Record> onHeadline;

    @Setter
    private Consumer<List<Record>> onData;

    public void process() {
        System.out.println("split intro headline and data");
    }

}
