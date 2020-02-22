package de.ccd.training.app.show.format;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

class InsertSeparatorColumns {

    @Setter
    private Consumer<List<Column>> onSeparatedColumns;

    @Setter
    private List<Column> columns;

    public void process(){
        System.out.println("insert separator columns");
    }


}
