package de.ccd.training.app.show.evaluate;

import de.ccd.training.adapter.PageStore;
import de.ccd.training.data.Page;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelectPreviousPage {

    private final PageStore pageStore;


    public Page process() {
        int activeIndex = pageStore.getActivePageIndex();
        int previousIndex = activeIndex - 1;
        if (activeIndex == 0) {
            previousIndex = pageStore.getPageCount() - 1;
        }
        pageStore.setActivePage(previousIndex);
        return pageStore.getActivePage();
    }

}
