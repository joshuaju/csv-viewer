package de.ccd.training.app.extract;

import lombok.RequiredArgsConstructor;
import de.ccd.training.adapter.FileSystem;
import lombok.Setter;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
class ReadFile {

    private final FileSystem fs;

    @Setter
    private Consumer<List<String>> onLines;

    @Setter
    private Path path;

    public void process(){
        System.out.println("read file");
    }

}
