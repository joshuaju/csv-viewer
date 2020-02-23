package de.ccd.training.app.extract;

import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class ConvertLinesToRecords {

    private final List<String> lines;

    @Setter
    private Consumer<List<Record>> onRecords;

    public void process() {
        var records = lines.stream()
                .map(line -> line.split(";"))
                .map(values -> new Record(Arrays.asList(values)))
                .collect(Collectors.toList());

        onRecords.accept(records);
    }

}
