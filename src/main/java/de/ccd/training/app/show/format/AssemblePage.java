package de.ccd.training.app.show.format;

import de.ccd.training.data.Column;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

class AssemblePage {

    @Setter
    private Consumer<String> onAssembledPage;

    @Setter
    private List<Column> columns;

    public void process() {
        System.out.println("assemble page");
    }

}
