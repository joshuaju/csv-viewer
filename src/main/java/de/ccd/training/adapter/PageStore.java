package de.ccd.training.adapter;

import de.ccd.training.data.Page;

import java.util.List;

public interface PageStore {

    void store(List<Page> pages);

    int getPageCount();

    void setActivePage(int pageIndex);

    int getActivePageIndex();

    Page getActivePage();
}
