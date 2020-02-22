package de.ccd.training.app.show.interact;

import de.ccd.training.adapter.Console;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class Interact {

    private final Console console;

    @Setter
    private Consumer<Character> onUserInput;

    @Setter
    private String formattedPage;

    public void process() {
        System.out.println("interact");
    }

}
