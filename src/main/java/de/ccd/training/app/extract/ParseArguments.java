package de.ccd.training.app.extract;

import lombok.Setter;

import java.nio.file.Path;
import java.util.function.Consumer;

class ParseArguments {

    @Setter
    Consumer<Path> onPath;
    @Setter
    Consumer<Integer> onPageLength;

    private String[] args;

    public ParseArguments(String[] args) {
        this.args = args;
    }

    public void process() {
        System.out.println("parse arguments");

        String path = args[0];
        onPath.accept(Path.of(path));

        int pageLength = 5;
        if (args.length > 1) pageLength = Integer.parseInt(args[1]);
        onPageLength.accept(pageLength);
    }
}
