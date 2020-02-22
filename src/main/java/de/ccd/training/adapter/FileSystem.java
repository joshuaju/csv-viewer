package de.ccd.training.adapter;

import java.nio.file.Path;
import java.util.List;

public interface FileSystem {

    List<String> readLines(Path path);

}
