package de.ccd.training.app.show.format.columns.padding;

import de.ccd.training.data.Column;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
class DetermineMax {

    private final Column column;

    @Setter
    private Consumer<Integer> onMaxColumnWidth;

    public void process() {
        System.out.println("determine max");
        column.getCells().stream()
                .map(String::length)
                .max(Integer::compareTo)
                .ifPresent(onMaxColumnWidth);
    }
}
