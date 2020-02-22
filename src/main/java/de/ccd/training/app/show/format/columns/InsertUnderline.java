package de.ccd.training.app.show.format.columns;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

class InsertUnderline {

    @Setter
    private List<Column> columns;

    @Setter
    private Consumer<List<Column>> onUnderlinedColumns;

    public void process(){
        System.out.println("insert underline");
    }

}
