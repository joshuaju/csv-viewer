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
        var parseArguments = new ParseArguments(args);
        var readFile = new ReadFile(fileSystem);
        var parseRecords = new ParseRecords(); // "extract records" in flow diagram

        parseArguments.setOnPath(readFile::setPath);
        parseArguments.setOnPageLength(onPageLength);
        readFile.setOnLines(parseRecords::setLines);
        parseRecords.setOnHeadLine(onHeadLine);
        parseRecords.setOnData(onData);

        parseArguments.process();
        readFile.process();
        parseRecords.process();
    }
}
