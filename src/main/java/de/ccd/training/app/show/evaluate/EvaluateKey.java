package de.ccd.training.app.show.evaluate;

import de.ccd.training.data.Page;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class EvaluateKey {

    @Setter
    private final Runnable onExit;
    @Setter
    private final Runnable onFirstPage;
    @Setter
    private final Runnable onPreviousPage;
    @Setter
    private final Runnable onNextPage;
    @Setter
    private final Runnable onLastPage;

    @Setter
    @Getter
    private Consumer<Page> onPageSelected;

    @Setter
    private Character key;

    public void process() {
        System.out.println("evaluate key");
    }

}
