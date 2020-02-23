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
        assert records.size() >= 2;
        onHeadline.accept(records.get(0));
        onData.accept(records.subList(1, records.size()));
    }

}
