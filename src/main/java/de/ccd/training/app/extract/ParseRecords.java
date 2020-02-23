package de.ccd.training.app.extract;

import de.ccd.training.data.Record;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

class ParseRecords {

    @Setter
    private Consumer<Record> onHeadLine;
    @Setter
    private Consumer<List<Record>> onData;

    @Setter
    private List<String> lines;

    public void process(){

        var convertLinesToRecords = new ConvertLinesToRecords(lines);
        var splitIntoHeadlineAndData = new SplitIntoHeadlineAndData();

        convertLinesToRecords.setOnRecords(splitIntoHeadlineAndData::setRecords);
        splitIntoHeadlineAndData.setOnHeadline(onHeadLine);
        splitIntoHeadlineAndData.setOnData(onData);

        convertLinesToRecords.process();
        splitIntoHeadlineAndData.process();
    }

}
