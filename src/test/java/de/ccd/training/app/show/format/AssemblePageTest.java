package de.ccd.training.app.show.format;

import de.ccd.training.app.show.format.columns.AssembleColumns;
import de.ccd.training.data.Column;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AssemblePageTest {


    String assembledPage = "";

    @Test
    void assemblePage() {
        var assemblePage = new AssemblePage();
        assemblePage.setColumns(List.of(
                new Column("c1", "--", "a "),
                new Column("|", "+", "|"),
                new Column("c3", "--", "c ")
        ));
        assemblePage.setOnAssembledPage(s -> assembledPage = s);
        assemblePage.process();

        assertThat(assembledPage).isEqualTo(
                "" +
                        "c1|c3\n" +
                        "--+--\n" +
                        "a |c \n"
        );
    }

}