package de.ccd.training.app.show.interact;

import de.ccd.training.adapter.Console;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class DisplayMenu {

    private final Console console;

    public void process() {
        console.display("F(irst, L(ast, N(ext, P(rev, eX(it: ");
    }
}
