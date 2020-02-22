package de.ccd.training.adapter;

import de.ccd.training.data.Page;

import java.util.List;

public class PageStoreImpl implements PageStore {

    private List<Page> pages;
    private Integer activePageIndex;

    @Override
    public void store(List<Page> pages) {
        this.pages = List.copyOf(pages);
    }

    @Override
    public void setActivePage(int pageIndex) {
        this.activePageIndex = pageIndex;
    }

    @Override
    public Page getActivePage() {
        return pages.get(activePageIndex);
    }
}
