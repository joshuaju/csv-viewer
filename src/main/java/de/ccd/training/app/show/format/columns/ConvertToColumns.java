package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import de.ccd.training.data.Page;
import de.ccd.training.data.Record;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
class ConvertToColumns {

    private final Record header;
    private final Page page;

    @Setter
    private Consumer<List<Column>> onConverted;

    public void process(){
        System.out.println("convert to columns");
    }


}
