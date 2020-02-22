package de.ccd.training.app.extract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class ParseArgumentsTest {

    Path path;
    Integer pageLength;

    @BeforeEach
    void beforeEach() {
        path = null;
        pageLength = null;
    }

    @Test
    void parseArgsWithJustPath() {
        var parseArguments = new ParseArguments(new String[]{"sample.csv"});
        parseArguments.setOnPath(p -> path = p);
        parseArguments.setOnPageLength(l -> pageLength = l);

        parseArguments.process();

        assertThat(path).isEqualTo(Path.of("sample.csv"));
    }

    @Test
    void parseArgsWithPathAndPageLength() {
        var parseArguments = new ParseArguments(new String[]{"sample.csv", "25"});
        parseArguments.setOnPath(p -> path = p);
        parseArguments.setOnPageLength(l -> pageLength = l);

        parseArguments.process();

        assertThat(path).isEqualTo(Path.of("sample.csv"));
        assertThat(pageLength).isEqualTo(25);
    }

}