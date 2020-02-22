package de.ccd.training.app.extract;

import de.ccd.training.adapter.FileSystem;
import de.ccd.training.data.Record;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

public class ExtractRecords {

    @Setter
    private Consumer<Record> onHeadLine;
    @Setter
    private Consumer<List<Record>> onData;
    @Setter
    private Consumer<Integer> onPageLength;

    private String[] args;
    private FileSystem fileSystem;

    public ExtractRecords(String[] args, FileSystem fileSystem) {
        this.args = args;
        this.fileSystem = fileSystem;
    }

    public void process() {
        System.out.println("extract records");
    }
}
