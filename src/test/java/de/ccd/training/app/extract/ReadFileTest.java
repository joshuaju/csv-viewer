package de.ccd.training.app.extract;

import de.ccd.training.adapter.FileSystem;
import de.ccd.training.adapter.FileSystemImpl;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    List<String> lines = new ArrayList<>();
    private Path testPath = Path.of("dummy.csv");;

    @Test
    void readFromFile() {
        FileSystem mockedFS = new FileSystem() {
            @Override
            public List<String> readLines(Path path) {
                if (path.equals(testPath))
                    return List.of(
                            "col1;col2",
                            "aa;bb"
                    );
                else
                    return List.of();
            }
        };

        var readFile = new ReadFile(mockedFS);
        readFile.setPath(testPath);
        readFile.setOnLines(lines::addAll);

        readFile.process();

        assertThat(lines).isEqualTo(List.of(
                "col1;col2",
                "aa;bb"
        ));
    }

}