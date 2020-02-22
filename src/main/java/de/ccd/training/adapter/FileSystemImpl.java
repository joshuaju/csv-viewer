package de.ccd.training.adapter;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSystemImpl implements FileSystem {

    @Override
    @SneakyThrows
    public List<String> readLines(Path path) {
        return Files.readAllLines(path);
    }
}
