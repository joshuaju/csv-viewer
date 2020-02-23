package de.ccd.training.app.show.evaluate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Page;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelectFirstPage {

    private final PageStore pageStore;

    public Page process() {
        pageStore.setActivePage(0);
        return pageStore.getActivePage();
    }

}
