package de.ccd.training.app.show.evaluate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Page;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelectNextPage {

    private final PageStore pageStore;


    public Page process() {
        int nextIndex = pageStore.getActivePageIndex() + 1 % pageStore.getPageCount();
        pageStore.setActivePage(nextIndex);
        return pageStore.getActivePage();
    }
}
