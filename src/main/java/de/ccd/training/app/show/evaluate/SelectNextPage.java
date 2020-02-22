package de.ccd.training.app.show.evaluate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Page;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class SelectNextPage {

    private final PageStore pageStore;

    @Setter
    private Consumer<Page> onPageSelected;

    public void process() {
        System.out.println("select next page");
    }
}
