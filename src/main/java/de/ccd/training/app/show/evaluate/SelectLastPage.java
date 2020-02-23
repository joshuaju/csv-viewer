package de.ccd.training.app.show.evaluate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Page;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelectLastPage {

    private final PageStore pageStore;

    public Page process() {
        pageStore.setActivePage(pageStore.getPageCount() - 1);
        return pageStore.getActivePage();
    }
}
