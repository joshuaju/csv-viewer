package de.ccd.training.app.show.evaluate;

import de.ccd.training.data.Page;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class EvaluateKey {

    private final Runnable onExit;
    private final Supplier<Page> onFirstPage;
    private final Supplier<Page> onPreviousPage;
    private final Supplier<Page> onNextPage;
    private final Supplier<Page> onLastPage;

    @Setter
    private Consumer<Page> onPageSelected;

    @Setter
    private Character key;

    public void process() {
        switch (key) {
            case 'x':
            case 'X':
                onExit.run();
                break;
            case 'f':
            case 'F':
                onPageSelected.accept(onFirstPage.get());
                break;
            case 'p':
            case 'P':
                onPageSelected.accept(onPreviousPage.get());
                break;
            case 'n':
            case 'N':
                onPageSelected.accept(onNextPage.get());
                break;
            case 'l':
            case 'L':
                onPageSelected.accept(onLastPage.get());
                break;
        }
    }

}
