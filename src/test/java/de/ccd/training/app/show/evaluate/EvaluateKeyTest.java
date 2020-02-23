package de.ccd.training.app.show.evaluate;

import de.ccd.training.data.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EvaluateKeyTest {

    boolean onExit;
    Page first;
    Page previous;
    Page next;
    Page last;
    Page selectedPage;
    EvaluateKey evaluateKey;

    @BeforeEach
    void beforeEach() {
        onExit = false;

        first = new Page();
        previous = new Page();
        next = new Page();
        last = new Page();
        selectedPage = null;

        evaluateKey = new EvaluateKey(
                () -> onExit = true,
                () -> first,
                () -> previous,
                () -> next,
                () -> last
        );
        evaluateKey.setOnPageSelected(page -> selectedPage = page);
    }

    @Test
    void exit() {
        evaluateKey.setKey('x');
        evaluateKey.process();

        assertThat(onExit).isTrue();
        assertThat(selectedPage).isNull();
    }

    @Test
    void first() {
        evaluateKey.setKey('f');
        evaluateKey.process();

        assertThat(selectedPage == first).isTrue();
    }

    @Test
    void next() {
        evaluateKey.setKey('n');
        evaluateKey.process();

        assertThat(selectedPage == next).isTrue();
    }

    @Test
    void previous() {
        evaluateKey.setKey('p');
        evaluateKey.process();

        assertThat(selectedPage == previous).isTrue();
    }

    @Test
    void last() {
        evaluateKey.setKey('l');
        evaluateKey.process();

        assertThat(selectedPage == last).isTrue();
    }


}