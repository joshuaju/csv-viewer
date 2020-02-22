package de.ccd.training.app.show.interact;

import de.ccd.training.adapter.Console;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class DisplayPage {

    private final Console console;
    private final String formattedPage;

    public void process() {
        System.out.println("display page");
        console.display(formattedPage + "\n");
    }

}
