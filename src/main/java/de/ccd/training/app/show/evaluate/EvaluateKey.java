package de.ccd.training.app.show.evaluate;

import de.ccd.training.data.Page;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class EvaluateKey {

    @Setter
    private Runnable onExit;
    @Setter
    private Runnable onFirstPage;
    @Setter
    private Runnable onPreviousPage;
    @Setter
    private Runnable onNextPage;
    @Setter
    private Runnable onLastPage;

    @Setter
    @Getter
    private Consumer<Page> onPageSelected;

    @Setter
    private Character key;

    public void process() {
        System.out.println("evaluate key");
    }

}
