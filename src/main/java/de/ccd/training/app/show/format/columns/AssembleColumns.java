package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class AssembleColumns {

    private final Record header;
    private final Page page;

    @Setter
    private Consumer<List<Column>> onAssembledColumns;

    public void process(){
        System.out.println("assemble process");
    }

}
