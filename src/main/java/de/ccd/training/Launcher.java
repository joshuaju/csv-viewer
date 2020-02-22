package de.ccd.training;

import de.ccd.training.app.ViewCSV;

public class Launcher {
    public static void main(String[] args) {
        var viewCSV = new ViewCSV(args);
        viewCSV.process();
    }
}
