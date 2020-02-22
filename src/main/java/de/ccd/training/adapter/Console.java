package de.ccd.training.adapter;

import java.nio.file.Path;
import java.util.List;

public interface Console {

    void display(String message);

    char readKey();

}
