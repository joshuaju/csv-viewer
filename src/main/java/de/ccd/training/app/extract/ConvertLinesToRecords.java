package de.ccd.training.app.extract;

import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
class ConvertLinesToRecords {

    private final List<String> lines;

    @Setter
    private Consumer<List<Record>> onRecords;

    public void process(){
        System.out.println("convert lines to records");
    }

}
