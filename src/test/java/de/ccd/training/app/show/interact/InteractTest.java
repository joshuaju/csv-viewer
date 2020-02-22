package de.ccd.training.app.show.interact;

import de.ccd.training.adapter.Console;
import de.ccd.training.adapter.ConsoleImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InteractTest {

    String display = "";
    Character userInput = null;

    @Test
    void interact() {
        Console console = new Console() {
            ArrayDeque<Character> keys = new ArrayDeque<>(List.of('n', 'p'));

            @Override
            public void display(String message) {
                display += message;
            }

            @Override
            public char readKey() {
                return keys.pollFirst();
            }
        };

        var interact = new Interact(console);
        interact.setFormattedPage("<FORMATTED PAGE PLACEHOLDER>");
        interact.setOnUserInput(key -> userInput = key);

        interact.process();

        assertThat(display).isEqualTo(
                "<FORMATTED PAGE PLACEHOLDER>\n" +
                        "F(irst, L(ast, N(ext, P(rev, eX(it: \n"
        );
        assertThat(userInput).isEqualTo('n');

        interact.process();

        assertThat(display).isEqualTo("" +
                "<FORMATTED PAGE PLACEHOLDER>\n" +
                "F(irst, L(ast, N(ext, P(rev, eX(it: \n" +
                "<FORMATTED PAGE PLACEHOLDER>\n" +
                "F(irst, L(ast, N(ext, P(rev, eX(it: \n"
        );
        assertThat(userInput).isEqualTo('p');
    }

}