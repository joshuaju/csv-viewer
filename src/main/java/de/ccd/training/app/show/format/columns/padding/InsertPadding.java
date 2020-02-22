package de.ccd.training.app.show.format.columns.padding;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

public class InsertPadding {

    @Setter
    private List<Column> columns;

    @Setter
    private Consumer<List<Column>> onPaddedColumns;

    public void process(){
        System.out.println("insert padding");
    }

}
