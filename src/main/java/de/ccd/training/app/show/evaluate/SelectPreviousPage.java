package de.ccd.training.app.show.evaluate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Page;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class SelectPreviousPage {

    private final PageStore pageStore;


    public Page process() {
        System.out.println("select previous page");
        return null;
    }
}
