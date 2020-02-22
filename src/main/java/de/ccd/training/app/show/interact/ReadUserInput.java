package de.ccd.training.app.show.interact;

import de.ccd.training.adapter.Console;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
class ReadUserInput {

    private final Console console;

    @Setter
    private Consumer<Character> onReceivedInput;

    public void process() {
        System.out.println("read user input");
        char key = console.readKey();
        onReceivedInput.accept(key);
    }
}
