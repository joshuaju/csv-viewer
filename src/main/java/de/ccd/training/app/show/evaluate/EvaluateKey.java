package de.ccd.training.app.show.evaluate;

import lombok.Setter;

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
    private Character key;

    public void process() {
        System.out.println("evaluate key");
    }

}
